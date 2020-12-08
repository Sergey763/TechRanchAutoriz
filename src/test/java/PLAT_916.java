import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import page.AutorizationPage;
import page.DomashnyaPage;
import page.ProfilePage;

import java.util.concurrent.TimeUnit;

public class PLAT_916 {
    private WebDriver driver;
    private DomashnyaPage vhod;
    private AutorizationPage auto;
    private ProfilePage profil;
    private String SITE_URL_ONE = "http://platform.dev.techranch.ru/accounts/sign_in";
    private String SITE_URL_TWO = "http://platform.dev.techranch.ru/";
    private String emailValid = "test@techranch.ru";
    private String passwordValid = "test1234";
    private By error = By.xpath("//div[@class=\"error-text\"]");

    @BeforeMethod
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        vhod = new DomashnyaPage(driver);
        auto = new AutorizationPage(driver);
        profil = new ProfilePage(driver);

    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

    @Test(description = "PLAT-985 Пользователь при клике на кнопку вход в шапке происходит переход на страницу авторизации")
    public void plat985() {
        driver.get(SITE_URL_TWO);
        vhod.clickVhod();
        Assert.assertTrue(vhod.checkDisplayed());
    }

    @Test(description = "PLAT-928 Пользователь, на страницу авторизации успешно авторизуется вводя валидные данные. Система переходит на страницу профиля")
    public void plat928() {
        driver.get(SITE_URL_ONE);
        auto.autorization(emailValid, passwordValid);
        profil.clickProfil();
        Assert.assertTrue(profil.exitDisplayed());
    }

    @Test(description = "PLAT-930 Пользователь, на страницу авторизации не может авторизоваться вводя не валидные данные")
    public void plat930() {
        driver.get(SITE_URL_ONE);
        auto.autorization("trololo@techranch.ru", "trololo1234");
        Assert.assertTrue(auto.strDisplayed(error));
    }

    @Test(description = "PLAT-931 Пользователь, на страницу авторизации не авторизуется вводя валидный email и не валидный пароль. Появляется сообщение под полем для ввода пароля: Неверный адрес email или пароль.")
    public void plat931() {
        driver.get(SITE_URL_ONE);
        auto.autorization(emailValid, "trololo1234");
        Assert.assertTrue(auto.strDisplayed(error));
    }

    @Test(description = "PLAT-951 Пользователь, на страницу авторизации не авторизуется оставляя поля Почта Пароль пустыми. Появляется сообщение под полем для ввода пароля: Неверный адрес email или пароль.")
    public void plat951() {
        driver.get(SITE_URL_ONE);
        auto.clickVoyti();
        Assert.assertTrue(auto.strDisplayed(error));
    }

    @Test(description = "PLAT-953 Пользователь, на страницу авторизации не авторизуется введя валидную почту и оставив поле пароль пустым. Появляется сообщение под полем для ввода пароля: Неверный адрес email или пароль.")
    public void plat953() {
        driver.get(SITE_URL_ONE);
        auto.typeEmail(emailValid);
        auto.clickVoyti();
        Assert.assertTrue(auto.strDisplayed(error));
    }
}


