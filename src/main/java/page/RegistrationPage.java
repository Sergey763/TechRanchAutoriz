package page;

import factory.Button;
import factory.DropDown;
import factory.ErrorField;
import factory.Field;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    public DropDown typeUserDown;
    public  DropDown typeUserList;
    public Field smiField;
    public Field firstNameField;
    public Field lastNameField;
    public Field phoneNumberField;
    public Field phonePhorm;
    public Field mailField;
    public Field nameOrganizationField;
    public Button moderationSendButton;
    public Button registrationButton;
    public ErrorField firstNameError;
    public ErrorField lastNameError;
    public ErrorField phoneError;
    public ErrorField mailErrorExist;
    public ErrorField phoneExist;
    public ErrorField mailErrorNotNull;
    public ErrorField nameOrganizationError;


    public RegistrationPage(WebDriver driver) {
        this.typeUserDown = new DropDown(driver, By.xpath("//span[text() = \"Бизнес\"]"));
        this.typeUserList = new DropDown(driver, By.xpath("//li[contains (@id, \"select2-organization_participant_kind\")]"));
        this.smiField = new Field(driver, By.xpath("//span[@id=\"select2-organization_participant_kind-container\"]"));
        this.moderationSendButton = new Button(driver, By.xpath("//input[@id = \"submit_registration_form\"]"));
        this.registrationButton = new Button(driver, By.xpath("//a[text() = \"Зарегистрироваться\"]"));
        this.firstNameField = new Field(driver, By.xpath("//input[@name=\"account[firs_name]\"]"));
        this.lastNameError = new ErrorField(driver, By.xpath("//div[@class = \"form-block form-block--first\"]/div[3]/div/div[text() = \"не может быть пустым\"]"));
        this.lastNameField = new Field(driver, By.xpath("//input[@name=\"account[last_name]\"]"));
        this.firstNameError = new ErrorField(driver,By.xpath("//div[@class = \"form-block form-block--first\"]/div[4]/div/div[text() = \"не может быть пустым\"]"));
        this.phoneNumberField = new Field(driver, By.xpath("//input[@name=\"account[phone]\"]"));
        this.phoneExist = new ErrorField(driver,By.xpath("//div[@class=\"error-text\"]"));
        this.phonePhorm = new Field(driver, By.xpath("//input[@name=\"account[phone]\"]"));
        this.phoneError = new ErrorField(driver, By.xpath("//div[@class = \"form-block form-block--first\"]/div[5]/div/div[text() = \"не может быть пустым\"]"));
        this.mailField = new Field(driver, By.xpath("//input[@name=\"account[email]\"]"));
        this.mailErrorExist = new ErrorField(driver, By.xpath("//div[@class = \"form-block form-block--first\"]/div[6]/div/div[text() = \"уже существует\"]"));
        this.mailErrorNotNull = new ErrorField(driver, By.xpath("//div[@class = \"form-block form-block--first\"]/div[6]/div/div[text() = \"не может быть пустым\"]"));
        this.nameOrganizationField = new Field(driver, By.xpath("//input[@name=\"organization[name_ru]\"]"));
        this.nameOrganizationError = new ErrorField(driver,By.xpath("//div[@class = \"form-block form-block--first\"]/div[7]/div/div[text() = \"не может быть пустым\"]"));
    }


}
