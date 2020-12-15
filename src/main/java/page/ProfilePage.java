package page;

import factory.Button;
import factory.Field;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    public Button buttonProfil;
    public Button buttonExit;
    public Field welcome;

    public ProfilePage(WebDriver driver) {
        this.buttonProfil = new Button(driver, By.xpath("//div[@class=\"header_inner\"]//li[7]/a"));
        this.buttonExit = new Button(driver, By.xpath("//div[@class=\"slide\"]//li[4]"));
        this.welcome = new Field(driver, By.xpath("//div[contains(text(), \"Вы успешно зарегистрировались.\")]"));
    }

}
