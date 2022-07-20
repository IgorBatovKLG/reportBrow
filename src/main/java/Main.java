import BrowserLogic.Authorization;
import Configuration.ConfigurationBrowser;
import CookiesDataBase.SafeCookies;
import Signature.DTO.SignatureDTO;
import Signature.HttpLogic.SelectSignatureModel;
import Signature.Models.SignatureModel;
import Signature.Models.SignatureModelHttp;
import Signature.Report.Signature;
import org.openqa.selenium.WebDriver;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        Runnable auth = RunnableConfig.Auth;
        auth.run();
        Thread.sleep(10000);
        RunnableConfig.Direction.run();

    }
}
