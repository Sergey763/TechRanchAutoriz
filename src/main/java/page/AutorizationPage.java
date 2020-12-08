package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutorizationPage {

    private WebDriver driver;

    public AutorizationPage(WebDriver driver) {
        this.driver = driver;
    }

//    private By emailField = By.xpath("//input[@name=\"account[email]\"]");
//    private By passwordField = By.xpath("//input[@id='account_password']");
//    private By buttonVoyti = By.xpath("//input[@type = 'submit' and @name = 'commit']");
//    private By error = By.xpath("//div[@class=\"error-text\"]");

    public ProfilePage clickVoyti() {
        driver.findElement(buttonVoyti).click();
        return new ProfilePage(driver);
    }



    public AutorizationPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public AutorizationPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public ProfilePage autorization(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickVoyti();
        return new ProfilePage(driver);
    }
    public AutorizationPage autorizationInvalid (String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickVoyti();
        return new AutorizationPage(driver);
    }
    public boolean strDisplayed(By element) {
        return driver.findElement(element).isDisplayed();
    }
}

