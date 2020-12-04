import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PLAT_916 {
    private WebDriver driver;
    private String SITE_URL_ONE = "http://platform.dev.techranch.ru/accounts/sign_in";
    private String SITE_URL_TWO = "http://platform.dev.techranch.ru/";
    private By buttonEnt = By.xpath("//div[@class=\"_1kFMl _1HmiM\"]//a");
    private By emailField = By.xpath("//input[@name=\"account[email]\"]");
    private By passwordField = By.xpath("//input[@id='account_password']");
    private By buttonValid = By.xpath("//input[@type = 'submit' and @name = 'commit']");
    private String emailValid = "test@techranch.ru";
    private String passwordValid = "test1234";
    private By error = By.xpath("//div[@class=\"error-text\"]");
    private By succes = By.xpath("//header//li[6]/a");
    private By succes2 = By.xpath("//div[@class=\"form-block form-block--first\"]//div/h1");


    @Test(description = "PLAT-985 Пользователь при клике на кнопку вход в шапке происходит переход на страницу авторизации")
    public void plat985() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(SITE_URL_TWO);
        driver.findElement(buttonEnt).click();
        Assert.assertTrue(getSuccess2().equals("Вход"));
        driver.quit();
    }

    @Test(description = "PLAT-928 Пользователь, на страницу авторизации успешно авторизуется вводя валидные данные. Система переходит на страницу профиля")
    public void plat928() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(SITE_URL_ONE);
        driver.findElement(emailField).sendKeys(emailValid);
        driver.findElement(passwordField).sendKeys(passwordValid);
        driver.findElement(buttonValid).click();
        Assert.assertTrue(getSuccess().equals("Мой профиль"));
        driver.quit();
    }

    @Test(description = "PLAT-930 Пользователь, на страницу авторизации не может авторизоваться вводя не валидные данные")
    public void plat930() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(SITE_URL_ONE);
        driver.findElement(emailField).sendKeys("trololo@techranch.ru");
        driver.findElement(passwordField).sendKeys("trololo1234");
        driver.findElement(buttonValid).click();
        Assert.assertTrue(getError().equals("Неверный пароль или email."));
        driver.quit();
        driver.quit();
    }

    @Test(description = "PLAT-931 Пользователь, на страницу авторизации не авторизуется вводя валидный email и не валидный пароль. Появляется сообщение под полем для ввода пароля: \"Неверный адрес email или пароль.\"\n" +
            "\n")
    public void plat931() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(SITE_URL_ONE);
        driver.findElement(emailField).sendKeys(emailValid);
         driver.findElement(passwordField).sendKeys("trololo234");
        driver.findElement(buttonValid).click();
        Assert.assertTrue(getError().equals("Неверный пароль или email."));
        driver.quit();
        driver.quit();
    }

    @Test(description = "PLAT-951 Пользователь, на страницу авторизации не авторизуется оставляя поля Почта Пароль пустыми. Появляется сообщение под полем для ввода пароля: Неверный адрес email или пароль.")
    public void plat951() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(SITE_URL_ONE);
        driver.findElement(buttonValid).click();
        Assert.assertTrue(getError().equals("Неверный пароль или email."));
        driver.quit();
        driver.quit();
    }

    @Test(description = "PLAT-953 Пользователь, на страницу авторизации не авторизуется введя валидную почту и оставив поле пароль пустым. Появляется сообщение под полем для ввода пароля: Неверный адрес email или пароль.")
    public void plat953() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(SITE_URL_ONE);
        driver.findElement(emailField).sendKeys(emailValid);
        driver.findElement(buttonValid).click();
        Assert.assertTrue(getError().equals("Неверный пароль или email."));
        driver.quit();
    }

    public String getError() {
        return driver.findElement(error).getText();
    }

    public String getSuccess() {
        return driver.findElement(succes).getText();
    }

    public String getSuccess2() {
        return driver.findElement(succes2).getText();
    }
}

