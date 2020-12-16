package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {

    private WebDriver driver;
    private By locator;

    public DropDown(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public void click() {
        driver.findElement(locator).click();
    }

    public String getText() {
        return driver.findElement(locator).getText();
    }


}
