package page;

import factory.Button;
import factory.ErrorField;
import factory.Field;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    public Button typeUserField;
    public Button smiField;
    public Field firstNameField;
    public Field lastNameField;
    public Field phoneNomberField;
    public Field mailField;
    public Field nameOrganizationField;
    public Button moderationSendButton;
    public Button registrationButton;
    public ErrorField firstNameError;
    public ErrorField lastNameError;
    public ErrorField phoneError;
    public ErrorField mailErrorExist;
    public ErrorField mailErrorNotNull;


    public RegistrationPage(WebDriver driver) {
        this.typeUserField = new Button(driver, By.xpath("//span[text() = \"Бизнес\"]"));
        this.smiField = new Button(driver, By.xpath("//li[text() = \"СМИ\"]"));
        this.moderationSendButton = new Button(driver, By.xpath("//div[@class=\"btn-holder\"]/input"));
        this.registrationButton = new Button(driver, By.xpath("//a[text() = \"Зарегистрироваться\"]"));
        this.firstNameField = new Field(driver, By.xpath("//div[@class = \"form-block form-block--first\"]/div[3]/div/input[@name = \"account[first_name]\"]"));
        this.lastNameError = new ErrorField(driver, By.xpath("//div[@class = \"form-block form-block--first\"]/div[3]/div/div[text() = \"не может быть пустым\"]"));
        this.lastNameField = new Field(driver, By.xpath("//div[@class = \"form-block form-block--first\"]/div[4]//div/input[@name = \"account[last_name]\"]"));
        this.firstNameError = new ErrorField(driver,By.xpath("//div[@class = \"form-block form-block--first\"]/div[4]/div/div[text() = \"не может быть пустым\"]"));
        this.phoneNomberField = new Field(driver, By.xpath("//div[@class = \"form-block form-block--first\"]/div[5]//div/input[@name = \"account[phone]\"]"));
        this.phoneError = new ErrorField(driver, By.xpath("//div[@class = \"form-block form-block--first\"]/div[5]/div/div[text() = \"не может быть пустым\"]"));
        this.mailField = new Field(driver, By.xpath("//div[@class = \"form-block form-block--first\"]/div[6]//div/input[@name = \"account[email]\"]"));
        this.mailErrorExist = new ErrorField(driver, By.xpath("//div[@class = \"form-block form-block--first\"]/div[6]/div/div[text() = \"уже существует\"]"));
        this.mailErrorNotNull = new ErrorField(driver, By.xpath("//div[@class = \"form-block form-block--first\"]/div[6]/div/div[text() = \"не может быть пустым\"]"));
        this.nameOrganizationField = new Field(driver, By.xpath("//div[@class = \"form-block form-block--first\"]/div[7]//div/input[@name = \"organization[name_ru]\"]"));
    }


}
