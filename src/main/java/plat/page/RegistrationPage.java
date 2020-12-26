package plat.page;

import jcactus.factory.Button;
import jcactus.factory.DropDown;
import jcactus.factory.ErrorField;
import jcactus.factory.Field;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    public DropDown typeUserDown;
    public  DropDown typeUserList;
    public Field smiField;
    public Field firstNameField;
    public Field lastNameField;
    // с опечатками надо бороться
    public Field phoneField;
    public Field mailField;
    public Field nameOrganizationField;
    public Field textRegistration;
    public Field organozationInn;
    public Button moderationSendButton;
    public Button registrationButton;
    public ErrorField firstNameError;
    public ErrorField lastNameError;
    public ErrorField phoneError;
    public ErrorField mailErrorExist;
    public ErrorField phoneExist;
    public ErrorField mailErrorNotNull;
    public ErrorField organozationInnError;
    public ErrorField nameOrganizationError;
    // Если ты используешь эти стринги для сверки текста, то лучше всего их писать прямо в тесте. //Подумал что лучше отнести к пэйджу где
   // используются все элементы страницы
    public String domain = "Введите часть адреса после символа \"@\". Адрес \"test@\" неполный.";
    public String noDomain = "Адрес электронной почты должен содержать символ \"@\". В адресе \"test\" отсутствует символ \"@\".";


    public RegistrationPage(WebDriver driver) {
        // Не согласен с реализацией, для одного элемента ты используешь две переменные, зачем? Что не позволяет в конструктор отправить два локатора?
        this.typeUserDown = new DropDown(driver, By.xpath("//span[text() = \"Бизнес\"]"), By.xpath("//li[contains (@id, \"select2-organization_participant_kind\")]"));
        //this.typeUserList = new DropDown(driver, By.xpath("//li[contains (@id, \"select2-organization_participant_kind\")]"));
        // Это зачем то еще используется в тестах //а как ты видишь реализацию?
        this.smiField = new Field(driver, By.xpath("//span[@id=\"select2-organization_participant_kind-container\"]"));
        this.moderationSendButton = new Button(driver, By.xpath("//input[@id = \"submit_registration_form\"]"));
        this.registrationButton = new Button(driver, By.xpath("//a[text() = \"Зарегистрироваться\"]"));
        // Примеры моих xpath, лаконичнее, не правда ли?
        this.firstNameField = new Field(driver, By.xpath("//input[@name=\"account[first_name]\"]"));
        this.firstNameError = new ErrorField(driver,By.xpath("//input[@id = 'account_first_name']/following-sibling::div[contains(text(), 'не может быть пустым')]"));
        this.lastNameField = new Field(driver, By.xpath("//input[@name=\"account[last_name]\"]"));
        //корявый xPath, но работает
        this.lastNameError = new ErrorField(driver, By.xpath("//input[@id=\"account_last_name\"]/following-sibling::div[contains(text(), 'не может быть пустым')]"));
        this.phoneField = new Field(driver, By.xpath("//input[@name=\"account[phone]\"]"));
        this.textRegistration = new Field(driver, By.xpath("//h1[text()=\"Регистрация\"]"));
        this.organozationInn = new Field(driver,By.xpath("//input[@name=\"organization[inn]\"]"));
        this.organozationInnError = new ErrorField(driver,By.xpath("//input[@id=\"organization_inn\"]/following-sibling::div[contains(text(), 'не может быть пустым')]"));
        //таких ероров на странице можнет быть целых несколько, тогда драйвер упадет
        this.phoneExist = new ErrorField(driver,By.xpath("//input[@id = 'account_phone']/following-sibling::div[contains(text(), 'уже существует')]"));
        // и вообще, у тебя один элемент, просто он отображает разный текст, в этом случае надо проверять выводимый текст а не плодить элементы в pom
        this.phoneError = new ErrorField(driver, By.xpath("//input[@id = 'account_phone']/following-sibling::div[contains(text(), 'не может быть пустым')]"));
        // к мылу также последний коммент относится //не понял
        this.mailField = new Field(driver, By.xpath("//input[@name=\"account[email]\"]"));
        this.mailErrorExist = new ErrorField(driver, By.xpath("//input[@id = 'account_email']/following-sibling::div[contains(text(), 'уже существует')]"));
        this.mailErrorNotNull = new ErrorField(driver, By.xpath("//input[@id = 'account_email']/following-sibling::div[contains(text(), 'не может быть пустым')]"));
        this.nameOrganizationField = new Field(driver, By.xpath("//input[@name=\"organization[name_ru]\"]"));
        // корече, батенька, заканчивайте заниматься альпинизмом, краткость - сетра таланта
        this.nameOrganizationError = new ErrorField(driver,By.xpath("//div[@class = \"form-block form-block--first\"]/div[7]/div/div"));
    }


}
