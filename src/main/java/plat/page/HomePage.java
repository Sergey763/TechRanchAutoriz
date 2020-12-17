package plat.page;

import jcactus.factory.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public Button button;

    public HomePage(WebDriver driver) {
        this.button = new Button(driver, By.xpath("//div[@class=\"_1kFMl _1HmiM\"]//a"));

    }
}
