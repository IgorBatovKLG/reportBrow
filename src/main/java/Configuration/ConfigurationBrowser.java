package Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigurationBrowser {

    public static WebDriver driver(){
        System.setProperty("webdriver.chrome.driver", "C:/TEMP/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
