package jcactus.factory;

import jcactus.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Field {

    private WebDriver driver;
    private By locator;

    public Field(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    // ToDo Хорошей практикой считается очистить поле, прежде чем его заполнять
    public void clear() {
        driver.findElement(locator).clear();
    }

    public void sendKeys(String text) {
        driver.findElement(locator).sendKeys(text);
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

    public String getTextHTML5Validation() {
        return driver.findElement(locator).getAttribute("validationMessage");
    }

    // ToDo getText обычно не работает в полях, значение поля input указывается в параметре value. Нужно возвращать его значение

     public String getValue(String attribute) {
         return driver.findElement(locator).getAttribute(attribute);
     }

}
