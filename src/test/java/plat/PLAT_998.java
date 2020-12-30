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

public class PLAT_998 {

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

    @Test(description = "PLAT-1017 Гость в верхнем меню сайта нажимая кнопку Зарегистрироваться переходит на страницу регистрации")
    public void plat1017() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.autorization"));
        registrationPage.registrationButton.click();

        //Проверка
        Assert.assertTrue(registrationPage.textRegistration.isDisplayed());
    }

    @Test(description = "PLAT-1018 На странице регистрации тип участника Бизнес установлен по умолчанию")
    public void plat1018() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));

        //Проверка
        Assert.assertEquals(registrationPage.typeUserDown.getText(),"Бизнес");
    }

    @Test(description = "PLAT-1019 Гость при вводе валидных данных авторизуется и переходит на страницу с профилем")
    public void plat1019() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.nameOrganizationField.sendKeys("Testoshka");
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertTrue(profilePage.welcome.isDisplayed());
    }

    @Test(description = "PLAT-1022 Гость при вводе валидных данных на английском языке переходит на страницу с профилем и ему отображается введенное им Наименование организации")
    public void plat1022() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.firstNameField.sendKeys("English");
        registrationPage.lastNameField.sendKeys("English");
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.nameOrganizationField.sendKeys("English");
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertTrue(profilePage.welcome.isDisplayed());

    }

    @Test(description = "PLAT-1050 На странице регистрации с типом участника Бизнес есть поле Наименование организации")
    public void plat1050() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));

        //Проверка
        Assert.assertTrue(registrationPage.nameOrganizationField.isDisplayed());

    }

    @Test(description = "PLAT-1051 Гость при вводе валидных данных, а поле Имя оставляя пустым, нажимая кнопку зарегистрироваться видит сообщение под пустым полем Не может быть пустым")
    public void plat1051() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.firstNameField.sendKeys("");
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.nameOrganizationField.sendKeys("Testoshka");
        registrationPage.moderationSendButton.click();

        //Првоерка
        Assert.assertTrue(registrationPage.firstNameError.isDisplayed());
    }

    @Test(description = "PLAT-1053 Гость при вводе валидных данных, а поле Фамилия оставляя пустым, нажимая кнопку зарегистрироваться видит сообщение под пустым полем Не может быть пустым")
    public void plat1053() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.sendKeys("");
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.nameOrganizationField.sendKeys("Testoshka");
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertTrue(registrationPage.lastNameError.isDisplayed());
    }
    @Test(description = "PLAT-1054 Гость при вводе валидных данных, а поле Телефон оставляя пустым, нажимая кнопку зарегистрироваться видит сообщение под пустым полем Не может быть пустым")
    public void plat1054() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.sendKeys("");
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.nameOrganizationField.sendKeys("Testoshka");
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertTrue(registrationPage.phoneError.isDisplayed());
    }
    @Test(description = "PLAT-1055 Гость при вводе валидных данных, а поле Почта оставляя пустым, нажимая кнопку зарегистрироваться видит сообщение под пустым полем Не может быть пустым")
    public void plat1055() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.sendKeys("");
        registrationPage.nameOrganizationField.sendKeys("Testoshka");
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertTrue(registrationPage.mailErrorNotNull.isDisplayed());
    }

    @Test(description = "PLAT-1056 Гость при вводе валидных данных, а поле Наименование организации оставляя пустым, нажимая кнопку зарегистрироваться видит сообщение под пустым полем Не может быть пустым")
    public void plat1056() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.nameOrganizationField.sendKeys("");
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertTrue(registrationPage.nameOrganizationError.isDisplayed());
    }

    @Test(description = "PLAT-1057 На странице регистрации при нажатии на поле Телефон появляется маска для ввода номера с типом +7")
    public void plat1057() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.phoneField.click();

        //Проверка
        Assert.assertEquals(registrationPage.phoneField.getValue(new PropertyLoader().getProperty("attributePhone")), "+7");
    }
    @Test(description = "PLAT-1058 Гость на странице регистрации при нажатии на поле Телефон может вводить только цифры")
    public void plat1058() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.phoneField.sendKeys("АБВГ@&");

        //Проверка
        Assert.assertEquals(registrationPage.phoneField.getValue(new PropertyLoader().getProperty("attributePhone")), "+7");
    }

    @Test(description = "PLAT-1059 Гость на странице регистрации с типом Бизнес^ заполнив все поля валидными данными, а в поле «Телефон» вводит уже зарегистрированную в системе телефон, не проходит регистрацию и видит текст красными «уже существует»")
    public void plat1059() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.sendKeys(new PropertyLoader().getProperty("phoneExist"));
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.nameOrganizationField.sendKeys("Testoshka");
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertTrue(registrationPage.phoneExist.isDisplayed());
    }
    @Test(description = "PLAT-1060 Гость на странице регистрации с типом Бизнес заполнив все поля валидными данными, а в поле «Почта» вводит уже зарегистрированную в системе почту, не проходит регистрацию и видит текст красными «уже существует»")
    public void plat1060() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.sendKeys(new PropertyLoader().getProperty("emailExist"));
        registrationPage.nameOrganizationField.sendKeys("Testoshka");
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertTrue(registrationPage.mailErrorExist.isDisplayed());
    }
    @Test(description = "PLAT-1062 Гость на странице регистрации, заполнив поле «Почта» без домена. Появляется текст Адрес электронной почты должен содержать символ @. В адресе test отсутствует символ @.»")
    public void plat1062() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.mailField.sendKeys(new PropertyLoader().getProperty("emailNoDomain"));
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertEquals(registrationPage.mailField.getTextHTML5Validation(),registrationPage.noDomain);
    }

    @Test(description = "PLAT-1062 Гость на странице регистрации с типом «Бизнес», заполнив все поля валидными данными, в поле «Почта» написать часть адреса с «test@». Появляется текст «Введите часть адреса после символа «@». Адрес test@ неполный »")
    public void plat1063() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.mailField.sendKeys(new PropertyLoader().getProperty("emailDomain"));
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertEquals(registrationPage.mailField.getTextHTML5Validation(),registrationPage.domain);
    }
}
