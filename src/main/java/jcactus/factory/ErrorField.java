package jcactus.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ErrorField {

    private WebDriver driver;
    private By locator;

    public ErrorField(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }
    public boolean isDispayed() {
       return driver.findElement(locator).isDisplayed();
    }

    public String getText() {
        return driver.findElement(locator).getText();
    }

}
