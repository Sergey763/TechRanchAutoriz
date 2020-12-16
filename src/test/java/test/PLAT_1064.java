package test;

import factory.DropDown;
import generator.Generator;
import generator.PlatGenerator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ProfilePage;
import page.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class PLAT_1064 {

    private WebDriver driver;
    private RegistrationPage registrationPage;
    private ProfilePage profilePage;
    private Generator generator;
    private String AUTORIZ_URL_TWO = "http://platform.dev.techranch.ru/accounts/sign_in";
    private String SIGN_UP_URL = "http://platform.dev.techranch.ru/accounts/sign_up";
    private String emailValid = "test@techranch.ru";

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

    @Test(description = "PLAT-1105 Гость в верхнем меню сайта при нажатии на кнопку зарегистрироваться, переходит на страницу регистрации")
    public void plat1105() {
        driver.get(AUTORIZ_URL_TWO);
        registrationPage.registrationButton.click();
       // Assert.assertTrue()
    }

    @Test(description = "PLAT-1106 У Гостя перейдя на странице регистрации в поле Тип участника по умолчанию тип Бизнес")
    public void plat1106() {
        driver.get(SIGN_UP_URL);
        Assert.assertEquals(registrationPage.typeUserDown.getText(),"Бизнес");
    }

    @Test(description = "PLAT-1108 Гость при вводе валидных данных на странице регистрации успешно переходит на страницу с профилем")
    public void plat1108() {
        driver.get(SIGN_UP_URL);
//        registrationPage.typeUserField.click();
//        registrationPage.smiField.click();
        registrationPage.typeUserDown.click();
        registrationPage.smiDropDown.click();
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneNomberField.sendKeys(generator.getPhone());
        registrationPage.mailField.sendKeys(emailValid);
        registrationPage.nameOrganizationField.sendKeys("Testoshka");
        registrationPage.registrationButton.click();
        Assert.assertTrue(profilePage.welcome.dispayed());

    }



}
