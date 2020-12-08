package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.AutorizationPage;

public class Field {

    private WebDriver driver;

    public Field(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.xpath("//input[@name=\"account[email]\"]");
    private By passwordField = By.xpath("//input[@id='account_password']");

    public void typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

}
