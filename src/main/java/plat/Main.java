package plat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import plat.page.AutorizationPage;

import java.util.concurrent.TimeUnit;

public class Main {

    static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://platform.dev.techranch.ru/accounts/sign_in");

        AutorizationPage a = new AutorizationPage(driver);
        //a.autorization("test@techranch.ru", "test1234");
        driver.quit();

    }
}
