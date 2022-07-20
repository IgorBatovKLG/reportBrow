package Signature.Report;


import Signature.DateBase.SignatureDateBase;
import Signature.Models.BuroSignatureModel;
import Signature.Models.SignatureModel;
import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Signature {

    public void ChackSignature(ArrayList<SignatureModel> models, ArrayList<String> cookies, String date, boolean news){

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parse = LocalDate.parse(date, formatter1);
        String format = parse.format(formatter2);
        ArrayList<SignatureModel> modelsWorks = new ArrayList<>();
        BuroSignatureModel b1 = new BuroSignatureModel("Бюро медико-социальной экспертизы №1", 0);
        BuroSignatureModel b2 = new BuroSignatureModel("Бюро медико-социальной экспертизы №2", 0);
        BuroSignatureModel b3 = new BuroSignatureModel("Бюро медико-социальной экспертизы №3", 0);
        BuroSignatureModel b4 = new BuroSignatureModel("Бюро медико-социальной экспертизы №4", 0);
        BuroSignatureModel b5 = new BuroSignatureModel("Бюро медико-социальной экспертизы №5", 0);
        BuroSignatureModel b6 = new BuroSignatureModel("Бюро медико-социальной экспертизы №6", 0);
        BuroSignatureModel b7 = new BuroSignatureModel("Бюро медико-социальной экспертизы №7", 0);
        BuroSignatureModel b8 = new BuroSignatureModel("Бюро медико-социальной экспертизы №8", 0);
        BuroSignatureModel b9 = new BuroSignatureModel("Бюро медико-социальной экспертизы №9", 0);
        BuroSignatureModel b10 = new BuroSignatureModel("Бюро медико-социальной экспертизы №10", 0);
        BuroSignatureModel b11 = new BuroSignatureModel("Бюро медико-социальной экспертизы №11", 0);
        BuroSignatureModel b12 = new BuroSignatureModel("Бюро медико-социальной экспертизы №12", 0);
        BuroSignatureModel b13 = new BuroSignatureModel("Бюро медико-социальной экспертизы №13", 0);
        BuroSignatureModel b15 = new BuroSignatureModel("Бюро медико-социальной экспертизы №15", 0);
        BuroSignatureModel b17 = new BuroSignatureModel("Бюро медико-социальной экспертизы №17", 0);
        BuroSignatureModel b18 = new BuroSignatureModel("Бюро медико-социальной экспертизы №18", 0);
        BuroSignatureModel b19 = new BuroSignatureModel("Бюро медико-социальной экспертизы №19", 0);
        BuroSignatureModel s101 = new BuroSignatureModel("Экспертный состав №1", 0);
        BuroSignatureModel s102 = new BuroSignatureModel("Экспертный состав №2", 0);
        BuroSignatureModel s103 = new BuroSignatureModel("Экспертный состав №3", 0);

        ArrayList<String> buroName = new ArrayList<>();
        try {
            buroName.add("Бюро медико-социальной экспертизы №1");
            buroName.add("Бюро медико-социальной экспертизы №2");
            buroName.add("Бюро медико-социальной экспертизы №3");
            buroName.add("Бюро медико-социальной экспертизы №4");
            buroName.add("Бюро медико-социальной экспертизы №5");
            buroName.add("Бюро медико-социальной экспертизы №6");
            buroName.add("Бюро медико-социальной экспертизы №7");
            buroName.add("Бюро медико-социальной экспертизы №8");
            buroName.add("Бюро медико-социальной экспертизы №10");
            buroName.add("Бюро медико-социальной экспертизы №11");
            buroName.add("Бюро медико-социальной экспертизы №12");
            buroName.add("Бюро медико-социальной экспертизы №13");
            buroName.add("Бюро медико-социальной экспертизы №15");
            buroName.add("Бюро медико-социальной экспертизы №17");
            buroName.add("Бюро медико-социальной экспертизы №18");
            buroName.add("Бюро медико-социальной экспертизы №19");
            buroName.add("Экспертный состав №1");
            buroName.add("Экспертный состав №2");
            buroName.add("Экспертный состав №3");
        } catch (Exception e) {}


        WebDriver driver = new ChromeDriver();
        driver.get("http://dbs/eva/");
        driver.manage().addCookie(new Cookie(cookies.get(0), cookies.get(2)));
        driver.manage().addCookie(new Cookie(cookies.get(1), cookies.get(3)));
        WebElement element;
        for (int i = 0; i < models.size(); i++) {
            int count = 0;
            ArrayList<String> names = new ArrayList<>();
            String[] split = models.get(i).getLink().split("/");
            String s = split[split.length - 1];
            driver.get("http://dbs/eva/Exam/Diagnosis/" + s);
            element = driver.findElement(By.xpath("//*[@id=\"tabData\"]"));
            element.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = true;
            int j = 1;

            try {
                while (b) {
                    element = driver.findElement(By.xpath("//*[@id=\"exam-specs\"]/div/table/tbody/tr[" + j + "]/td[2]"));
                    String innerText = element.getAttribute("innerText");
                    String[] s1 = innerText.split(" ");
                    String name = s1[s1.length - 1];
                    names.add(name);
                    j++;
                }
            } catch (Exception e) {
                b = false;
            }
            driver.get(models.get(i).getLink() + "?tab=tabDocsResult");
            j = 1;
            b = true;
            String link = null;
            try {
                while (b) {
                    element = driver.findElement(By.xpath("//*[@id=\"tableDocsResult\"]/tbody/tr[" + j + "]/td[1]/a"));

                    if (element.getAttribute("innerText").contains("Протокол")) {
                        link = element.getAttribute("href");
                        b = false;
                    }
                    j++;
                }
            } catch (Exception e) {
                b = false;
            }
            int countNames = names.size();
            if (link != null) {
                driver.get(link);
                j = 1;
                b = true;
                while (b) {
                    try {
                        element = driver.findElement(By.xpath("//*[@id=\"listSignatures\"]/ul/li[" + j + "]/a"));
                    } catch (Exception e) {
                        b = false;
                    }
                    String innerText = element.getAttribute("innerText");
                    String[] s1 = innerText.split(" ");

                    if (names.contains(s1[0])) {
                        count++;
                        names.remove(s1[0]);
                    }
                    j++;
                }
            }

            if (count != countNames) {
                System.out.println("-------------------------------------------------------");
                System.out.println(models.get(i).getLink());
                System.out.println(models.get(i).getBuro() + " Нет электронной подписи у инвалида " + models.get(i).getName());
                System.out.println("Список сотрудников не поставивших электронную подпись");
                names.stream().forEach(System.out::println);
                models.get(i).setSignatureName(names);
                modelsWorks.add(models.get(i));
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№1")
                        &&!models.get(i).getBuro().contains("№10")
                        &&!models.get(i).getBuro().contains("№11")
                        &&!models.get(i).getBuro().contains("№12")
                        &&!models.get(i).getBuro().contains("№13")
                        &&!models.get(i).getBuro().contains("№15")
                        &&!models.get(i).getBuro().contains("№17")
                        &&!models.get(i).getBuro().contains("№18")
                        &&!models.get(i).getBuro().contains("№19")
                ){
                    b1.setCount(b1.getCount()+1);}
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№2")){b2.setCount(b2.getCount()+1);}
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№3")){b3.setCount(b3.getCount()+1);}
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№4")){b4.setCount(b4.getCount()+1);}
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№5")){b5.setCount(b5.getCount()+1);}
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№6")){b6.setCount(b6.getCount()+1);}
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№7")){b7.setCount(b7.getCount()+1);}
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№8")){b8.setCount(b8.getCount()+1);}
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№9")){b9.setCount(b9.getCount()+1);}
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№10")){b10.setCount(b10.getCount()+1);}
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№11")){b11.setCount(b11.getCount()+1);}
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№12")){b12.setCount(b12.getCount()+1);}
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№13")){b13.setCount(b13.getCount()+1);}
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№15")){b15.setCount(b15.getCount()+1);}
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№17")){b17.setCount(b17.getCount()+1);}
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№18")){b18.setCount(b18.getCount()+1);}
                if (models.get(i).getBuro().contains("Бюро")&&models.get(i).getBuro().contains("№19")){b19.setCount(b19.getCount()+1);}
                if (models.get(i).getBuro().contains("Экспертный")&&models.get(i).getBuro().contains("№1")){s101.setCount(s101.getCount()+1);}
                if (models.get(i).getBuro().contains("Экспертный")&&models.get(i).getBuro().contains("№2")){s102.setCount(s102.getCount()+1);}
                if (models.get(i).getBuro().contains("Экспертный")&&models.get(i).getBuro().contains("№3")){s103.setCount(s103.getCount()+1);}

            }


        }

        ArrayList<BuroSignatureModel> modelBuro = new ArrayList<>();
        try {
            modelBuro.add(b1);
            modelBuro.add(b2);
            modelBuro.add(b3);
            modelBuro.add(b4);
            modelBuro.add(b5);
            modelBuro.add(b6);
            modelBuro.add(b7);
            modelBuro.add(b8);
            modelBuro.add(b9);
            modelBuro.add(b10);
            modelBuro.add(b11);
            modelBuro.add(b12);
            modelBuro.add(b13);
            modelBuro.add(b15);
            modelBuro.add(b17);
            modelBuro.add(b18);
            modelBuro.add(b19);
            modelBuro.add(s101);
            modelBuro.add(s102);
            modelBuro.add(s103);
        }catch (Exception e){}
        int i = 0;


        Gson gson = new Gson();
        String json = gson.toJson(modelBuro);
        String json2 = gson.toJson(modelsWorks);

        SignatureDateBase signatureDateBase = new SignatureDateBase();
        boolean jsonBuro = true;
        boolean JsonWorkers = true;
        boolean newsBool = true;
        while (jsonBuro){
            jsonBuro = signatureDateBase.setJsonBuro(json, format);
        }
        while (JsonWorkers){
            JsonWorkers = signatureDateBase.setJsonWorkers(json2, format);
        }
        while (newsBool){
            int countForNews = signatureDateBase.getCountForNews();
            if (news) {
                newsBool = signatureDateBase.setNews(countForNews + 1, date);
            }
        }



        driver.quit();
    }
}
