package page;

import factory.Button;
import factory.ErrorField;
import factory.Field;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.AutorizationPage;

public class DomashnyaPage {

    public Button button;

    public DomashnyaPage(WebDriver driver) {
        this.button = new Button(driver, By.xpath("//div[@class=\"_1kFMl _1HmiM\"]//a"));

    }
}
