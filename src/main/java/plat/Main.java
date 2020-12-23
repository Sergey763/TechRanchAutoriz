package plat;

import io.github.bonigarcia.wdm.WebDriverManager;
import jcactus.factory.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import plat.page.AutorizationPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.w3schools.com/html/html_tables.asp");


        Table table = new Table(driver,By.xpath("//table[@id=\"customers\"]"));

        System.out.println("Rows number is: " + table.getRows().size());
        String result = "";
        System.out.println(table.getRows().get(3).getText());
//        for(WebElement rows : table.getRows()){
//            result = rows.getText();
//            System.out.println(result);
//            System.out.println(rows);
//        }


//        System.out.println(table.getValueFromCell(2, 3));
//        System.out.println(table.getValueFromCell(4, 1));
//
//        System.out.println(table.getValueFromCell(4, "Company"));
//        System.out.println(table.getValueFromCell(1, "Country"));
//        System.out.println(table.getValueFromCell(2, "Contact"));

    }
}
