package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.AutorizationPage;

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

    public boolean isDispayed() {
        return driver.findElement(locator).isDisplayed();
    }

    public String getText() {
        return driver.findElement(locator).getText();
    }
}
