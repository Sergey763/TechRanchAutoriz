/**
 * В классе Table парсится стандартная html тюблица содержащая thead и tbody
 * Строки в thead и tbody имеют тег tr
 * Столбцы в thead имеют тег th
 * Столбыц в tbody имеют тег td
 */

package jcactus.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class Table {

    private WebElement table;

    public Table(WebDriver driver, By locator) {
        this.table = driver.findElement(locator);
    }

    /**
     * getRows возвращает список сторок в виде WebElement
<<<<<<< Updated upstream
     * @return
     */
    public List<WebElement> getRows() {
        List<WebElement> rows = table.findElements(By.xpath(".//tr")); //нашли все строки
        rows.remove(0); //вычли заголовки
        return rows;
    }

    /**
     * getHeadings возвращает список заголовков столбцов в виде WebElement
<<<<<<< Updated upstream
     * @return
     */

    public List<WebElement> getHeadings() {
        WebElement headingsRow = table.findElement(By.xpath(".//tr[1]")); //нашли заголовки
        List<WebElement> headingColumns = headingsRow.findElements(By.xpath(".//th"));//конкретное значение в списке заголовков
        return headingColumns;
    }

    /**
     * getHeadingsWithRows возвращает список строк со списком столбцов в виде WebElement
<<<<<<< Updated upstream
     * @return
     */
    public List<List<WebElement>> getRowsWithColumns() {
        List<WebElement> rows = getRows(); //есть список всех строк
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for (WebElement row : rows) { //прошлись по каждому значению списка
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));//и нашли все значения внутри каждой строки
            rowsWithColumns.add(rowWithColumns);
        }
//        WebElement cell = rowsWithColumns.get(1);
//        System.out.println(rowsWithColumns.get(1));

        return rowsWithColumns;

    }

//    public List<Map<String, WebElement>> getRowsWithColumnsByHeadings(){
//    }
    /**
     * Возвращет
     * (Лист - список всех строк,
     * каждая строка это Map (String заголовок, WebElement конкретная ячейка которая будет возвращаться по этому заголовку).
     * По заголовку мы можем найти ячейку конкретного столбца.
     */

    public List<Map<String, WebElement>> getRowsWithColumnsByHeadings() {

        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();//уточнить про этот метод еще раз
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowByHeadings;
        List<WebElement> headingColumns = getHeadings();//список всех заголовков
        for (List<WebElement> row : rowsWithColumns) {
            rowByHeadings = new HashMap<String, WebElement>();
            for (int i = 0; i < headingColumns.size(); i++) {
                String heading = headingColumns.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeadings.put(heading, cell);
            }
            rowsWithColumnsByHeadings.add(rowByHeadings);
        }
        return rowsWithColumnsByHeadings;
    }


    /**
     * Возвращает ячейку как WebElement из столбца returningColumn из той строки, у которой есть значение
     * searchValue в столбце searchColumn.
     * @param searchValue
     * @param searchColumn
     * @param returningColumn
     * @return
     */
//    public WebElement getCell(String searchValue, int searchColumn, int returningColumn) {
//    }

    /**
     * Возвращает true, если значение searchValue найдена в столбце searchColumn
<<<<<<< Updated upstream
=======
     *
>>>>>>> Stashed changes
     * @param searchValue
     * @param searchColumn
     * @return
     */
//    public boolean searchCell(String searchValue, int searchColumn) {
//    }

    public boolean searchCell(String searchValue, int searchColumn) {
        if (searchValue == null) {
            return false;
        }
        if (searchColumn == 0) {
            return false;
        }

        List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
        String text = rowsWithColumnsByHeadings.get(searchColumn - 1).get(searchValue).getText();
        if(text.equals(searchColumn)) return true;
        return false;

//    List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
//        return rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName).getText();
    }
}


