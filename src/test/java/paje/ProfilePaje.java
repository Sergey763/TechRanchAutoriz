package paje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePaje {

    private WebDriver driver;

    public ProfilePaje(WebDriver driver) {
        this.driver = driver;
    }

    private By profilButton = By.xpath("//div[@class=\"header_inner\"]//li[7]/a");
    private By exit = By.xpath("//div[@class=\"slide\"]//li[4]");

    public ProfilePaje clickProfil() {
        driver.findElement(profilButton).click();
        return new ProfilePaje(driver);
    }
    public boolean exitDisplayed() {
        return driver.findElement(exit).isDisplayed();
    }
}
