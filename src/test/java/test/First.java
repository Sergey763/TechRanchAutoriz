package test;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.swing.text.Element;
import java.util.concurrent.TimeUnit;

public class First {

    //private WebDriver driver;
    private String SITE_URL_ONE = "http://platform.dev.techranch.ru/accounts/sign_in";
    private String SITE_URL_TWO = "https://platform.plus-one.ru/";

//    @BeforeSuite
//    public void start() {
//        WebDriverManager.chromedriver().setup();
//    }

    @Test(description = "PLAT-985 Пользователь при клике на кнопку вход в шапке происходит переход на страницу авторизации")
    public void plat985() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(SITE_URL_TWO);
        WebElement element = driver.findElement(By.xpath("//div[@class = \"_1kFMl _1HmiM\"]/a"));
        //header//div[@data-id = 'open-menu']/following-sibling::div/a[contains(text(), 'Вход')]
       // element.isDisplayed();//почиатать
        element.click();
        driver.quit();
    }

    @Test
    public void testTwo() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(SITE_URL_ONE);
        WebElement inputMail = driver.findElement(By.xpath("//input[@autofocus = \"autofocus\" and @type = \"text\"]"));
        inputMail.sendKeys("test@techranch.ru");
        WebElement inputPass = driver.findElement(By.xpath("//input[@type=\"password\" and @name = \"account[password]\"]"));
        inputPass.sendKeys("test1234");
        driver.findElement(By.xpath("//input[@type = 'submit' and @name = 'commit']")).click();
        driver.quit();
    }

    @Test
    public void testThree() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(SITE_URL_ONE);
        WebElement inputMail = driver.findElement(By.xpath("//input[@autofocus = \"autofocus\" and @type = \"text\"]"));
        inputMail.sendKeys("trololo@techranch.ru");
        WebElement inputPass = driver.findElement(By.xpath("//input[@type=\"password\" and @name = \"account[password]\"]"));
        inputPass.sendKeys("trololo1234");
        driver.findElement(By.xpath("//input[@type = 'submit' and @name = 'commit']")).click();
        driver.quit();
    }

    @Test
    public void testFour() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(SITE_URL_ONE);
        WebElement inputMail = driver.findElement(By.xpath("//input[@autofocus = \"autofocus\" and @type = \"text\"]"));
        inputMail.sendKeys("test@techranch.ru");
        WebElement inputPass = driver.findElement(By.xpath("//input[@type=\"password\" and @name = \"account[password]\"]"));
        inputPass.sendKeys("trololo234");
        driver.findElement(By.xpath("//input[@type = 'submit' and @name = 'commit']")).click();
        driver.quit();
    }

    @Test
    public void testFive() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(SITE_URL_ONE);
        driver.findElement(By.xpath("//input[@type = 'submit' and @name = 'commit']")).click();
        driver.quit();
    }

    @Test
    public void testSix() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(SITE_URL_ONE);
        WebElement inputMail = driver.findElement(By.xpath("//input[@autofocus = \"autofocus\" and @type = \"text\"]"));
        inputMail.sendKeys("trololo@techranch.ru");
        driver.findElement(By.xpath("//input[@type = 'submit' and @name = 'commit']")).click();
        driver.quit();
    }


//    @AfterSuite
//    public void finish() {
//        driver.quit();
//    }
}
