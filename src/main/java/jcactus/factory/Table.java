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

import java.util.List;

public class Table {

    private WebElement table;

    public Table(WebDriver driver, By locator) {
        this.table = driver.findElement(locator);
    }

    /**
     * getRows возвращает список сторок в виде WebElement
     * @return
     */
//    public List<WebElement> getRows() {
//    }

    /**
     * getHeadings возвращает список заголовков столбцов в виде WebElement
     * @return
     */
//    public List<WebElement> getHeadings() {
//    }

    /**
     * getHeadingsWithRows возвращает список строк со списком столбцов в виде WebElement
     * @return
     */
//    public List<List<WebElement>> getRowsWithColumns() {
//    }

//    public List<Map<String, WebElement>> getRowsWithColumnsByHeadings(){
//    }

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
     * @param searchValue
     * @param searchColumn
     * @return
     */
//    public boolean searchCell(String searchValue, int searchColumn) {
//    }

}
