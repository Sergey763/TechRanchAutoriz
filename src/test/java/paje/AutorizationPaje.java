package paje;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutorizationPaje {

    private WebDriver driver;

    public AutorizationPaje(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.xpath("//input[@name=\"account[email]\"]");
    private By passwordField = By.xpath("//input[@id='account_password']");
    private By buttonVoyti = By.xpath("//input[@type = 'submit' and @name = 'commit']");
    private By error = By.xpath("//div[@class=\"error-text\"]");

    public ProfilePaje clickVoyti() {
        driver.findElement(buttonVoyti).click();
        return new ProfilePaje(driver);
    }

    public AutorizationPaje typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public AutorizationPaje typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public ProfilePaje autorization(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickVoyti();
        return new ProfilePaje(driver);
    }
    public AutorizationPaje autorizationInvalid (String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickVoyti();
        return new AutorizationPaje(driver);
    }
    public boolean strDisplayed(By element) {
        return driver.findElement(element).isDisplayed();
    }
}

