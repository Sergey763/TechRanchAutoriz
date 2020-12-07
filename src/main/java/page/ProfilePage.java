package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private By profilButton = By.xpath("//div[@class=\"header_inner\"]//li[7]/a");
    private By exit = By.xpath("//div[@class=\"slide\"]//li[4]");

    public ProfilePage clickProfil() {
        driver.findElement(profilButton).click();
        return new ProfilePage(driver);
    }
    public boolean exitDisplayed() {
        return driver.findElement(exit).isDisplayed();
    }
}
