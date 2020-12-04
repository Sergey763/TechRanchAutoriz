package test;

        import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.Assert;
        import org.testng.annotations.AfterSuite;
        import org.testng.annotations.BeforeSuite;
        import org.testng.annotations.Test;
        import org.testng.asserts.Assertion;

        import javax.swing.text.Element;
        import java.util.concurrent.TimeUnit;

public class First {

    //private WebDriver driver;
    private String SITE_URL_ONE = "http://platform.dev.techranch.ru/accounts/sign_in";
    private String SITE_URL_TWO = "https://platform.plus-one.ru/"; // !!! Используй только дев !!!


    @Test(description = "PLAT-985 Пользователь при клике на кнопку вход в шапке происходит переход на страницу авторизации")
    public void plat985() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(SITE_URL_TWO);
        WebElement element = driver.findElement(By.xpath("//a[text() = 'Вход']"));
        //header//div[@data-id = 'open-menu']/following-sibling::div/a[contains(text(), 'Вход')]
        //System.out.println(element.isDisplayed());//почиатать
        Assert.assertTrue(element.isDisplayed(),"трололо неверно");

        System.out.println(driver.getCurrentUrl());
        element.click();
        driver.quit();
    }

    @Test(description = "PLAT-928 Пользователь, на страницу авторизации успешно авторизуется вводя валидные данные. Система переходит на страницу профиля\n" +
            "\n")
    public void plat928() {
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

    @Test(description = "PLAT-930 Пользователь, на страницу авторизации не может авторизоваться вводя не валидные данные")
    public void plat930() {
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

    @Test(description = "PLAT-931 Пользователь, на страницу авторизации не авторизуется вводя валидный email и не валидный пароль. Появляется сообщение под полем для ввода пароля: \"Неверный адрес email или пароль.\"\n" +
            "\n")
    public void plat931() {
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

    @Test(description = "PLAT-951 Пользователь, на страницу авторизации не авторизуется оставляя поля \"Почта\" \"Пароль\" пустыми. Появляется сообщение под полем для ввода пароля: \"Неверный адрес email или пароль.\"\n" +
            "\n")
    public void plat951() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(SITE_URL_ONE);
        driver.findElement(By.xpath("//input[@type = 'submit' and @name = 'commit']")).click();
        driver.quit();
    }

    @Test(description = "PLAT-953 Пользователь, на страницу авторизации не авторизуется введя валидную почту и оставив поле пароль пустым. Появляется сообщение под полем для ввода пароля: \"Неверный адрес email или пароль.\"\n" +
            "\n")
    public void plat953() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(SITE_URL_ONE);
        WebElement inputMail = driver.findElement(By.xpath("//input[@autofocus = \"autofocus\" and @type = \"text\"]"));
        inputMail.sendKeys("test@techranch.ru");
        driver.findElement(By.xpath("//input[@type = 'submit' and @name = 'commit']")).click();
        driver.quit();
    }

}
