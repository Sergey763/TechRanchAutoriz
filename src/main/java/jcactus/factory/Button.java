package jcactus.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {

    private WebDriver driver;
    private By locator;

    public Button(WebDriver driver,By locator) {
            this.driver = driver;
            this.locator = locator;
    }

    public void click() {
        driver.findElement(locator).click();
    }

    public boolean isDisplayed() {
        return driver.findElement(locator).isDisplayed();
    }

    public String getText() {
        return driver.findElement(locator).getText();
    }
}
