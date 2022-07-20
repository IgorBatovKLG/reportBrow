package BrowserLogic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Authorization {

    public static ArrayList<String> inSite(String login, String password, WebDriver driver){
        driver.get("http://dbs/eva/");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement input = driver.findElement(By.xpath("//*[@id='Login']"));

        input.sendKeys(login);


        input = driver.findElement(By.xpath("//*[@id='Password']"));

        input.sendKeys(password);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        input = driver.findElement(By.xpath("//*[@id='btnSubmit']"));
        input.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        input = driver.findElement(By.xpath("//*[@id=\"msgBox\"]/div/div/div[3]/button"));
        input.click();

        ArrayList<String> strings = SafeCookies.SafeInDB(driver);

        return strings;
    }
}
