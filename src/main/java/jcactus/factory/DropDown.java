package jcactus.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropDown {

    private WebDriver driver;
    private By locatorUserDown;
    private By locatorList;

    public DropDown(WebDriver driver, By locatorUserDown, By locatorList) {
        this.driver = driver;
        this.locatorUserDown = locatorUserDown;
        this.locatorList = locatorList;
    }

//    public void click() {
//        driver.findElement(locator).click();
//    }

    public void clickList(int number) {
        driver.findElement(locatorUserDown).click();
        List<WebElement> checkDrops = driver.findElements(locatorList);
        checkDrops.get(number).click();

    }

    public String getText() {
        return driver.findElement(locatorUserDown).getText();
    }


}
