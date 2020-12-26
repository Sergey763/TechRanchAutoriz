package plat;

import io.github.bonigarcia.wdm.WebDriverManager;
import jcactus.PropertyLoader;
import jcactus.generator.Generator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import plat.generator.PlatGenerator;
import plat.page.ProfilePage;
import plat.page.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class PLAT_1194 {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private ProfilePage profilePage;
    private Generator generator;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationPage = new RegistrationPage(driver);
        profilePage = new ProfilePage(driver);
        generator = new PlatGenerator();

    }

    @AfterMethod
    public void testDown() {
        driver.quit();
    }

    @Test(description = "PLAT-1251 Гость переходит на страницу регистрации при нажатии кнопки Зарегистрироваться в верхнем меню сайта")
    public void plat1251() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.autorization"));
        registrationPage.registrationButton.click();

        //Проверка
        Assert.assertTrue(registrationPage.textRegistration.isDisplayed());
    }

    @Test(description = "PLAT-1252 У гостя на странице регистрации при выборе типа участника НКО появляется поле ИНН ")
    public void plat1252() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.typeUserDown.clickList(1);;

        //Проверка
        Assert.assertTrue(registrationPage.organozationInn.isDisplayed());
    }
    @Test(description = "PLAT-1255 У гостя на странице регистрации при нажатии на поле Телефон появляется форма для ввода номера формата +7")
    public void plat1255() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.phoneField.click();

        //Проверка
        Assert.assertEquals(registrationPage.phoneField.getValue(new PropertyLoader().getProperty("attributePhone")), "+7");
    }

    @Test(description = "PLAT-1256 Гость на странице регистрации в поле Телефон может ввести только цифры")
    public void plat1256() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.phoneField.sendKeys("АБВГ@&");

        //Проверка
        Assert.assertEquals(registrationPage.phoneField.getValue(new PropertyLoader().getProperty("attributePhone")), "+7");
    }

    @Test(description = "PLAT-1257 Гость на странице регистрации в поле Телефон на странице регистрации в поле Телефон может ввести только только 10 цифр")
    public void plat1257() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.phoneField.sendKeys(generator.getPhone()+ "7");

        //Проверка
        Assert.assertEquals(registrationPage.phoneField.getValue(new PropertyLoader().getProperty("attributePhoneNumber")).length(), 11);
    }

    @Test(description = "PLAT-1449 На странице регистрации при кнопка Отправить на модерацию по умолчанию не активна")
    public void plat1449() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));

        //Проверка
        Assert.assertFalse(registrationPage.moderationSendButton.isEnabled());
    }

    @Test(description = "PLAT-1450 На странице регистрации при нажатии на радио кнопку кнопка Отправить на модерацию становится активна")
    public void plat1450() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));

        //Проверка
        Assert.assertFalse(registrationPage.moderationSendButton.isEnabled());
    }
}
