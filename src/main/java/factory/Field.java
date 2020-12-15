package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.AutorizationPage;

public class Field {

    private WebDriver driver;
    private By locator;

    public Field(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public void sendKeys(String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void click() {
        driver.findElement(locator).click();
    }


    public boolean dispayed() {
        return driver.findElement(locator).isDisplayed();
    }

    public String text() {
        return driver.findElement(locator).getText();
    }

}
