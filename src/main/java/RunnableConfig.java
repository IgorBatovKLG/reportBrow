import BrowserLogic.Authorization;
import Configuration.ConfigurationBrowser;
import Direction.DataBase.DirectionSelectDb;
import Direction.DataBase.DirectionUpdateDb;
import Direction.Logic.BrowserDirection;
import Direction.Logic.ErrorDirection;
import Direction.Models.DirectionCountModel;
import Signature.DTO.SignatureDTO;
import Signature.HttpLogic.SelectSignatureModel;
import Signature.Models.SignatureModel;
import Signature.Models.SignatureModelHttp;
import Signature.Report.Signature;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RunnableConfig {

    static Runnable Auth = new Runnable() {
        public void run() {
            WebDriver driver = ConfigurationBrowser.driver();
            Main.strings =  Authorization.inSite("батов", "49VbkCkeIgsAjh", driver);
        }
    };
    static Runnable Signature = new Runnable() {
        public void run() {
            SelectSignatureModel selectSignatureModel = new SelectSignatureModel();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            List<SignatureModelHttp> signatureExam = selectSignatureModel.getSignatureExam(LocalDate.now().format(formatter).toString(), Main.strings);
            Signature signature = new Signature();
            ArrayList<SignatureModel> signatureModels = SignatureDTO.fromDTO(signatureExam);
            signature.ChackSignature(signatureModels, Main.strings, LocalDate.now().format(formatter).toString(), true);
        }
    };

    static Runnable Direction = new Runnable() {
        @Override
        public void run() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            BrowserDirection browserDirection = new BrowserDirection();
            ErrorDirection errorDirection = new ErrorDirection();

            WebDriver driver = new ChromeDriver();
            driver.get("http://dbs/eva/");
            driver.manage().addCookie(new Cookie(Main.strings.get(0), Main.strings.get(2)));
            driver.manage().addCookie(new Cookie(Main.strings.get(1), Main.strings.get(3)));

            ArrayList<String> directionList = browserDirection.getDirectionList(Main.strings, LocalDate.now().minusDays(2).format(formatter).toString());
            try {
                Thread.sleep(1000*15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (String s:directionList){
                browserDirection.DirectionInit(s, driver);
            }

            DirectionSelectDb directionSelectDb = new DirectionSelectDb();
            ArrayList<String> hrefNotCloset = directionSelectDb.getHrefNotCloset();
            for (String s:hrefNotCloset){
                driver.get(s);
                WebElement element = driver.findElement(By.xpath("//*[@id=\"docStatus\"]"));
                String status = element.getAttribute("innerText");
                if (status.equals("Закрыто")){
                    DirectionUpdateDb directionUpdateDb = new DirectionUpdateDb();
                    directionUpdateDb.updateStatus(status, s);
                }
            }
            ArrayList<String> hrefCloset = directionSelectDb.getHrefCloset();
            for (String s:hrefCloset) {
                driver.get(s);
                DirectionCountModel countSpan = browserDirection.getCountSpan(s, driver);
                DirectionUpdateDb directionUpdateDb = new DirectionUpdateDb();
                int errorCode = errorDirection.NotRecordAndMissingExams(countSpan);
                if (errorCode==0){
                    directionUpdateDb.updateFullStop(countSpan.getMseRecordsCount(),
                            countSpan.getMissingMedExamsCount(),
                            countSpan.getTfomsCount(),
                            "false",
                            "false",
                            "stop",
                            "false" ,
                            s
                            );
                }
                if (errorCode==1){
                    directionUpdateDb.updateFullStop(countSpan.getMseRecordsCount(),
                            countSpan.getMissingMedExamsCount(),
                            countSpan.getTfomsCount(),
                            "true",
                            "false",
                            "stop",
                            "true" ,
                            s
                    );
                }
                if (errorCode==2){
                    directionUpdateDb.updateFullStop(countSpan.getMseRecordsCount(),
                            countSpan.getMissingMedExamsCount(),
                            countSpan.getTfomsCount(),
                            "false",
                            "true",
                            "stop",
                            "true" ,
                            s
                    );
                }
            }
            driver.quit();
        }
    };
}
