package paje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DomashnyaPage {

    private WebDriver driver;

    public DomashnyaPage(WebDriver driver) {
        this.driver = driver;
    }
    private By buttonVhod = By.xpath("//div[@class=\"_1kFMl _1HmiM\"]//a");

    public AutorizationPaje clickVhod() {
        driver.findElement(buttonVhod).click();
        return new AutorizationPaje(driver);
    }

}
