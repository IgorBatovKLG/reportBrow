package Direction.Logic;

import Direction.DataBase.DirectionInsertDB;
import Direction.Models.DirectionCountModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BrowserDirection {


    public ArrayList<String> getDirectionList(ArrayList<String> cookies, String date){
        ArrayList<String> hrefList = new ArrayList<>();


        WebElement element;
        WebDriver driver = new ChromeDriver();
        driver.get("http://dbs/eva/");
        driver.manage().addCookie(new Cookie(cookies.get(0), cookies.get(2)));
        driver.manage().addCookie(new Cookie(cookies.get(1), cookies.get(3)));

        driver.get("http://dbs/eva/Requests/ReqList?NeedSearch=True&CreateTimeFrom=18.07.2022&CreateTimeTo=18.07.2022&ReqType=5&PageSize=1000&BrokenDeadlines=false&IsNoRecordsMSE=false");

        element = driver.findElement(By.xpath("//*[@id=\"table-container\"]/table/tbody"));
        int countElement = Integer.parseInt(element.getAttribute("childElementCount"));

        for (int i = 1; i <= countElement; i++){
            element = driver.findElement(By.xpath("//*[@id=\"table-container\"]/table/tbody/tr["+i+"]/td[1]/a"));
            String href = element.getAttribute("href");
            hrefList.add(href);
        }

        driver.quit();
        return hrefList;
    }

    public DirectionCountModel getCountSpan(String href, WebDriver driver){
        driver.get(href);
        WebElement element;
        element = driver.findElement(By.xpath("//*[@id=\"spanMseRecordsCount\"]"));
        String MseRecordsCount = element.getAttribute("innerText");
        element = driver.findElement(By.xpath("//*[@id=\"spanMissingMedExamsCount\"]"));
        String MissingMedExamsCount = element.getAttribute("innerText");
        element = driver.findElement(By.xpath("//*[@id=\"spanTfomsCount\"]"));
        String TfomsCount = element.getAttribute("innerText");
        element = driver.findElement(By.xpath("//*[@id=\"txtInNumber\"]"));
        String number = element.getAttribute("value");
        DirectionCountModel directionCountModel = new DirectionCountModel(Integer.parseInt(MseRecordsCount), Integer.parseInt(MissingMedExamsCount), Integer.parseInt(TfomsCount), number);
        return directionCountModel;
        }

    public void DirectionInit(String href, WebDriver driver){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        driver.get(href);
        WebElement element;
        String dStart = "";
        String dAnd = "";
        element = driver.findElement(By.xpath("//*[@id=\"dtCreateDate\"]"));
        String dateStart = element.getAttribute("value");

        element = driver.findElement(By.xpath("//*[@id=\"dtSysRegDate\"]"));
        String dateAnd = element.getAttribute("value");

        element = driver.findElement(By.xpath("//*[@id=\"selPerson\"]"));
        String info = element.getAttribute("innerText");

        element = driver.findElement(By.xpath("//*[@id=\"editPanel\"]/div[2]"));
        String[] split = element.getAttribute("innerText").split(" ");
        String hash = split[split.length-1];

        element = driver.findElement(By.xpath("//*[@id=\"docStatus\"]"));
        String status = element.getAttribute("innerText");




        if (dateStart.length()>2) {
            dStart = LocalDate.parse(dateStart, formatter1).format(formatter).toString();
        }
        if (dateAnd.length()>2) {
            dAnd = LocalDate.parse(dateAnd, formatter1).format(formatter).toString();
        }
        DirectionInsertDB directionInsertDB = new DirectionInsertDB();
        boolean db = true;
        while (db){
            db = directionInsertDB.InsertNewDirection(href,
                    hash,
                    info,
                    dStart,
                    dAnd,
                    status);
        }
    }
}
