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

public class PLAT_915 {

    private WebDriver driver;
    private RegistrationPage registrationPage;
    private ProfilePage profilePage;
    private Generator generator;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        registrationPage = new RegistrationPage(driver);
        profilePage = new ProfilePage(driver);
        generator = new PlatGenerator();
    }

    @AfterMethod
    public void testDown() {
        driver.quit();
    }

    @Test(description = "PLAT-958 У гостя на странице регистрации выбирая тип «Эксперт» В списке полей для заполнения, убирается поле «Наименование организации»")
    public void plat958(){
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.typeUserDown.clickList(3);

        //Проверка
        Assert.assertFalse(registrationPage.nameOrganizationField.isDisplayed());
    }

    @Test(description = "PLAT-969 Гость на странице регистрации выбирая тип «Эксперт» и заполнив все поля валидными данными, авторизуется и переходит на страницу с профилем")
    public void plat969() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.typeUserDown.clickList(3);
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertTrue(profilePage.welcome.isDisplayed());
    }

    @Test(description = "PLAT-970 Гость на странице регистрации с типом Эксперт,заполнив поле «Почта» без домена. Появляется текст Адрес электронной почты должен содержать символ @. В адресе test отсутствует символ @.")
    public void plat970() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.typeUserDown.clickList(3);;
        registrationPage.mailField.sendKeys(new PropertyLoader().getProperty("emailNoDomain"));
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertEquals(registrationPage.mailField.getTextHTML5Validation(),registrationPage.noDomain);

    }

    @Test(description = "PLAT-971 Гость на странице регистрации выбирая тип «Эксперт» и заполнив все поля в английской раскладке валидными данными авторизуется и переходит на страницу профиля")
    public void plat971() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.typeUserDown.clickList(3);;
        registrationPage.firstNameField.sendKeys("English");
        registrationPage.lastNameField.sendKeys("English");
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertTrue(profilePage.welcome.isDisplayed());
    }

    @Test(description = "PLAT-972 Гость на странице регистрации выбирая тип «Эксперт» заполняя поля валидными данными, в поле «Телефон» вводит уже зарегистрированный в системе телефон  не проходит регистрацию и видит текст красными буквами «уже существует»")
    public void plat972() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.typeUserDown.clickList(3);;
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.sendKeys(new PropertyLoader().getProperty("phoneExist"));
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertTrue(registrationPage.phoneExist.isDisplayed());
    }

    @Test(description = "PLAT-973 Гость на странице регистрации выбирая тип «Эксперт» и заполнив все поля валидными данными, в поле «Почта» вводит уже зарегистрированную в системе почту, не проходит регистрацию и видит текст красными буквами «уже существует»")
    public void plat973() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.typeUserDown.clickList(3);;
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.sendKeys(new PropertyLoader().getProperty("emailExist"));
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertTrue(registrationPage.mailErrorExist.isDisplayed());
    }

    @Test(description = "PLAT-975 На странице регистрации при нажатии на поле Телефон появляется маска для ввода номера с типом +7")
    public void plat975() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.phoneField.click();

        //Проверка
        Assert.assertEquals(registrationPage.phoneField.getValue(new PropertyLoader().getProperty("attributePhone")), "+7");
    }

    @Test(description = "PLAT-976 На странице регистрации в поле Телефон можно вводить только цифры")
    public void plat976() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.phoneField.sendKeys("АБВГ@&");

        //Проверка
        Assert.assertEquals(registrationPage.phoneField.getValue(new PropertyLoader().getProperty("attributePhone")), "+7");
    }

    @Test(description = "PLAT-977 Гость на странице регистрации с типом «Эксперт», написав в поле «Почта» часть адреса с «test@». Появляется текст Введите часть адреса после символа @. Адрес test+501test@ неполный.")
    public void plat977() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.typeUserDown.clickList(3);;
        registrationPage.mailField.sendKeys(new PropertyLoader().getProperty("emailDomain"));
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertEquals(registrationPage.mailField.getTextHTML5Validation(),registrationPage.domain);
    }

    @Test(description = "PLAT-986 Пользователь при клике на кнопку \"зарегистрироваться\" в шапке происходит переход на страницу регистрации")
    public void plat986() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.autorization"));
        registrationPage.registrationButton.click();

        //Проверка
        Assert.assertTrue(registrationPage.textRegistration.isDisplayed());
    }

    @Test(description = "PLAT-987 Гость на странице регистрации c типом «Эксперт», оставив поле «Имя» пустым и заполнив остальные поля валидными данными, не проходит регистрацию и видит текст красными буквами под незаполненным полем «не может быть пустым»")
    public void plat987() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.typeUserDown.clickList(3);;
        registrationPage.firstNameField.sendKeys("");
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.moderationSendButton.click();

        //Првоерка
        Assert.assertTrue(registrationPage.firstNameError.isDisplayed());
    }

    @Test(description = "PLAT-988 Гость на странице регистрации c типом «Эксперт», оставив поле «Фамилия» пустым и заполнив остальные поля валидными данными, не проходит регистрацию и видит текст красными буквами под незаполненным полем «не может быть пустым»")
    public void plat988() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.typeUserDown.clickList(3);;
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.sendKeys("");
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertTrue(registrationPage.lastNameError.isDisplayed());
    }
    @Test(description = "PlAT-989 Гость на странице регистрации c типом «Эксперт», оставив поле «Телефон» пустым и заполнив остальные поля валидными данными, не проходит регистрацию и видит текст красными буквами под незаполненным полем «не может быть пустым»")
    public void plat989() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.typeUserDown.clickList(3);;
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.sendKeys("");
        registrationPage.mailField.sendKeys(generator.getMail());
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertTrue(registrationPage.phoneError.isDisplayed());
    }

    @Test(description = "PLAT-990 Гость на странице регистрации c типом «Эксперт», оставив поле «Почта» пустым и заполнив остальные поля валидными данными, не проходит регистрацию и видит текст красными буквами под незаполненным полем «не может быть пустым»")
    public void plat990() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.typeUserDown.clickList(3);;
        registrationPage.firstNameField.sendKeys(generator.getName());
        registrationPage.lastNameField.sendKeys(generator.getSurname());
        registrationPage.phoneField.sendKeys(generator.getPhone());
        registrationPage.mailField.sendKeys("");
        registrationPage.moderationSendButton.click();

        //Проверка
        Assert.assertTrue(registrationPage.mailErrorNotNull.isDisplayed());
    }

    @Test(description = "PLAT-1444 Гость на странице регистрации в поле Тип участника успешно устанавливает тип Эксперт")
    public void plat1444() {
        //Шаги
        driver.get(new PropertyLoader().getProperty("platform.signUp"));
        registrationPage.typeUserDown.clickList(3);;

        //Проверка
        Assert.assertEquals(registrationPage.smiField.getText(),"Эксперт");

    }


}
