package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {

    private WebDriver driver;

    public Button(WebDriver driver) {
        this.driver = driver;
    }

    private By buttonVoyti = By.xpath("//input[@type = 'submit' and @name = 'commit']");
    private By buttonVhod = By.xpath("//div[@class=\"_1kFMl _1HmiM\"]//a");
    private By profilButton = By.xpath("//div[@class=\"header_inner\"]//li[7]/a");
    private By exit = By.xpath("//div[@class=\"slide\"]//li[4]");

    public void clickVoyti() {
        driver.findElement(buttonVoyti).click();
    }

    public void clickVhod() {
        driver.findElement(buttonVhod).click();
    }

    public void clickProfil() {
        driver.findElement(profilButton);
    }
}
