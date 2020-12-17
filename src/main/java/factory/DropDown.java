package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public void clickList(int number) {
        List<WebElement> checkDrops = driver.findElements(locator);
        checkDrops.get(number).click();

    }

    public String getText() {
        return driver.findElement(locator).getText();
    }


}
