package jcactus.factory;

import jcactus.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Link {

    private WebDriver driver;
    private By locator;

    public Link(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public void click() {
        driver.findElement(locator).click();
        new Message().successMessage("Выполнено нажатие на ссылку " + this.locator.toString());
    }

    public String getText() {
        String text = driver.findElement(locator).getText();
        new Message().successMessage("Ссылка " + this.locator.toString() + " содержит текст " + text);
        return text;
    }
// ToDo метод должен возвращать значение указанного атрибута

    public String getAttribute(String attribute) {

        return driver.findElement(locator).getAttribute(attribute);
    }

}
