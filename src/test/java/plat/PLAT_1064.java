package plat;

import jcactus.generator.Generator;
import io.github.bonigarcia.wdm.WebDriverManager;
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

public class PLAT_1064 {

    private WebDriver driver;
    private RegistrationPage registrationPage;
    private ProfilePage profilePage;
    private Generator generator;
    private String AUTORIZ_URL_TWO = "http://platform.dev.techranch.ru/accounts/sign_in";
    private String SIGN_UP_URL = "http://platform.dev.techranch.ru/accounts/sign_up";
    private String emailDomain = "test@";
    private String emailNoDomain = "test";
    private String emailExist = "test@techranch.ru";
    private String phoneExist = "9999307766";
    public String attributePhone = "placeholder";


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
        //Assert.assertTrue() ИДЕИ?
    }

    @Test(description = "PLAT-1106 У Гостя перейдя на странице регистрации в поле Тип участника по умолчанию тип Бизнес")
    public void plat1106() {
        driver.get(SIGN_UP_URL);
        Assert.assertEquals(registrationPage.typeUserDown.getText(),"Бизнес");
    }

    @Test(description = "PLAT-1107 Гость на странице регистрации в поле Тип участника успешно устанавливает тип СМИ")
    public void plat1107() {
        driver.get(SIGN_UP_URL);
        registrationPage.typeUserDown.clickList(2);;
        Assert.assertEquals(registrationPage.smiField.getText(),"СМИ");

    }

    @Test(description = "PLAT-1108 Гость при вводе валидных данных на странице регистрации успешно переходит на страницу с профилем")
    public void plat1108() {
        driver.get(SIGN_UP_URL);
        registrationPage.typeUserDown.clickList(2);;

        registrationPage.firstNameField.clear();
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.clear();
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.clear();
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.clear();
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.nameOrganizationField.clear();
        registrationPage.nameOrganizationField.sendKeys("Testoshka");
        registrationPage.moderationSendButton.click();
        Assert.assertTrue(profilePage.welcome.isDisplayed());

    }

    @Test(description = "PLAT-1111 Гость при вводе валидных данных на английском языке проходит регистрацию и переходит на страницу с профилем")
    public void plat1111() {
        driver.get(SIGN_UP_URL);
        registrationPage.typeUserDown.clickList(2);;

        registrationPage.firstNameField.clear();
        registrationPage.firstNameField.sendKeys("English");
        registrationPage.lastNameField.clear();
        registrationPage.lastNameField.sendKeys("English");
        registrationPage.phoneField.clear();
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.clear();
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.nameOrganizationField.clear();
        registrationPage.nameOrganizationField.sendKeys("English");
        registrationPage.moderationSendButton.click();
        Assert.assertTrue(profilePage.welcome.isDisplayed());

    }

    @Test(description = "PLAT-1137 Гость при при нажатии кнопки Зарегистрироваться с валидными данными и пустым полем Имя, видит сообщение под пустым полем Не может быть пустым")
    public void plat1137() {
        driver.get(SIGN_UP_URL);
        registrationPage.typeUserDown.clickList(2);;

        registrationPage.firstNameField.clear();
        registrationPage.firstNameField.sendKeys("");
        registrationPage.lastNameField.clear();
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.clear();
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.clear();
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.nameOrganizationField.clear();
        registrationPage.nameOrganizationField.sendKeys("Testoshka");
        registrationPage.moderationSendButton.click();
        Assert.assertTrue(registrationPage.firstNameError.isDisplayed());
    }

    @Test(description = "PLAT-1139 Гость при при нажатии кнопки Зарегистрироваться с валидными данными и пустым полем Фамилия, видит сообщение под пустым полем Не может быть пустым")
    public void plat1139() {
        driver.get(SIGN_UP_URL);
        registrationPage.typeUserDown.clickList(2);;

        registrationPage.firstNameField.clear();
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.clear();
        registrationPage.lastNameField.sendKeys("");
        registrationPage.phoneField.clear();
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.clear();
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.nameOrganizationField.clear();
        registrationPage.nameOrganizationField.sendKeys("Testoshka");
        registrationPage.moderationSendButton.click();
        Assert.assertTrue(registrationPage.lastNameError.isDisplayed());
    }


    @Test(description = "PLAT-1140 Гость при при нажатии кнопки Зарегистрироваться с валидными данными и пустым полем Телефон, видит сообщение под пустым полем Не может быть пустым")
    public void plat1140() {
        driver.get(SIGN_UP_URL);
        registrationPage.typeUserDown.clickList(2);;

        registrationPage.firstNameField.clear();
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.clear();
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.clear();
        registrationPage.phoneField.sendKeys("");
        registrationPage.mailField.clear();
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.nameOrganizationField.clear();
        registrationPage.nameOrganizationField.sendKeys("Testoshka");
        registrationPage.moderationSendButton.click();
        Assert.assertTrue(registrationPage.phoneError.isDisplayed());
    }

    @Test(description = "PLAT-1141 Гость при при нажатии кнопки Зарегистрироваться с валидными данными и пустым полем Почта, видит сообщение под пустым полем Не может быть пустым")
    public void plat1141() {
        driver.get(SIGN_UP_URL);
        registrationPage.typeUserDown.clickList(2);;

        registrationPage.firstNameField.clear();
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.clear();
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.clear();
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.clear();
        registrationPage.mailField.sendKeys("");
        registrationPage.nameOrganizationField.clear();
        registrationPage.nameOrganizationField.sendKeys("Testoshka");
        registrationPage.moderationSendButton.click();
        Assert.assertTrue(registrationPage.mailErrorNotNull.isDisplayed());
    }

    @Test(description = "PLAT-1142 Гость при при нажатии кнопки Зарегистрироваться с валидными данными и пустым полем Наименование организации, видит сообщение под пустым полем Не может быть пустым")
    public void plat1142() {
        driver.get(SIGN_UP_URL);
        registrationPage.typeUserDown.clickList(2);;

        registrationPage.firstNameField.clear();
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.clear();
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.clear();
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.clear();
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.nameOrganizationField.clear();
        registrationPage.nameOrganizationField.sendKeys("");
        registrationPage.moderationSendButton.click();
        Assert.assertTrue(registrationPage.nameOrganizationError.isDisplayed());
    }

    @Test(description = "PLAT-1143 На странице регистрации при нажатии на поле Телефон появляется маска для ввода номера с типом +7")
    public void plat1143() {
        driver.get(SIGN_UP_URL);
        registrationPage.phoneField.click();
        Assert.assertEquals(registrationPage.phoneField.getValue(attributePhone), "+7");
    }

    @Test(description = "PLAT-1144 На странице регистрации в поле Телефон можно вводить только цифры")
    public void plat1144() {
        driver.get(SIGN_UP_URL);
         registrationPage.phoneField.clear();
        registrationPage.phoneField.sendKeys("АБВГ@&");
        Assert.assertEquals(registrationPage.phoneField.getValue(attributePhone), "+7");
    }

    @Test(description = "PLAT-1145 Гость на странице регистрации с типом СМИ указав валидные данные, и «Телефон» который уже зарегистрирован в системе, видит текст красными буквами «уже существует»")
    public void plat1145() {
        driver.get(SIGN_UP_URL);
        registrationPage.typeUserDown.clickList(2);;

        registrationPage.firstNameField.clear();
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.clear();
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.clear();
        registrationPage.phoneField.sendKeys(phoneExist);
        registrationPage.mailField.clear();
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.nameOrganizationField.clear();
        registrationPage.nameOrganizationField.sendKeys("Testoshka");
        registrationPage.moderationSendButton.click();
        Assert.assertTrue(registrationPage.phoneExist.isDisplayed());
    }

    @Test(description = "PLAT-1146 Гость на странице регистрации с типом СМИ указав валидные данные, и «Почта» которая уже зарегистрирована в системе, видит текст красными буквами «уже существует»")
    public void plat1146() {
        driver.get(SIGN_UP_URL);
        registrationPage.typeUserDown.clickList(2);;

        registrationPage.firstNameField.clear();
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.clear();
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.clear();
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.clear();
        registrationPage.mailField.sendKeys(emailExist);
        registrationPage.nameOrganizationField.clear();
        registrationPage.nameOrganizationField.sendKeys("Testoshka");
        registrationPage.moderationSendButton.click();
        Assert.assertTrue(registrationPage.mailErrorExist.isDisplayed());
    }

    @Test(description = "PLAT-1147 Гость на странице регистрации с типом СМИ заполнив все поля валидными данными, а в поле «Наименование организации» вводит уже зарегистрированную в системе такую организацию, переходит на страницу профиля")
    public void plat1147() {
        driver.get(SIGN_UP_URL);
        registrationPage.typeUserDown.clickList(2);;

        registrationPage.firstNameField.clear();
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.clear();
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.clear();
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.clear();
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.nameOrganizationField.clear();
        registrationPage.nameOrganizationField.sendKeys("Testoshka");
        registrationPage.moderationSendButton.click();
        Assert.assertTrue(profilePage.welcome.isDisplayed());
    }

    @Test(description = "PLAT-1148 Гость на странице регистрации с типом «СМИ»,заполнив поле «Почта» без домена. Появляется текст Адрес электронной почты должен содержать символ @. В адресе test отсутствует символ @.»")
    public void plat1148() {
        driver.get(SIGN_UP_URL);
        registrationPage.typeUserDown.clickList(2);;

        registrationPage.firstNameField.clear();
        registrationPage.mailField.sendKeys(emailNoDomain);
        registrationPage.moderationSendButton.click();
        Assert.assertEquals(registrationPage.mailField.getTextHTML5Validation(),registrationPage.noDomain);
    }
    @Test(description = "PLAT-1149 Гость на странице регистрации с типом «СМИ», написав в поле «Почта» часть адреса с «test@». Появляется текст Введите часть адреса после символа @. Адрес test+501test@ неполный.")
    public void plat1149() {
        driver.get(SIGN_UP_URL);
        registrationPage.typeUserDown.clickList(2);;

        registrationPage.firstNameField.clear();
        registrationPage.mailField.sendKeys(emailDomain);
        registrationPage.moderationSendButton.click();
        Assert.assertEquals(registrationPage.mailField.getTextHTML5Validation(),registrationPage.domain);
    }

}