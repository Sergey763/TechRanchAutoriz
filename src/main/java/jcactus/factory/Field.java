package jcactus.factory;

import jcactus.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Field {

    private WebDriver driver;
    private By locator;

    public Field(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public void clear() {
        driver.findElement(locator).clear();
    }

    public void sendKeys(String text) {
        clear();
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(text);
        if (m.matches() & text.length()==10) {
            driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
        }
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
