package BrowserLogic;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class SafeCookies {


    public static ArrayList<String> SafeInDB(WebDriver driver){
        Set<Cookie> cookies = driver.manage().getCookies();
        ArrayList<Cookie> cookieArrayList = new ArrayList<>(cookies);
        String name0 = cookieArrayList.get(0).getName();
        String name1 = cookieArrayList.get(1).getName();
        String value0 = cookieArrayList.get(0).getValue();
        String value1 = cookieArrayList.get(1).getValue();
        ArrayList<String> cookie = new ArrayList<>();
        cookie.add(name0);
        cookie.add(name1);
        cookie.add(value0);
        cookie.add(value1);
        return cookie;
    }
}
