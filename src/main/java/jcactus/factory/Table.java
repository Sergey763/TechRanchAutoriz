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

public class Table {

    private WebElement table;

    public Table(WebDriver driver, By locator) {
        this.table = driver.findElement(locator);
    }

    /**
     * getRows возвращает список сторок в виде WebElement
     * @return
     */
    public List<WebElement> getRows() {
        List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        rows.remove(0);
        return rows;
    }

    /**
     * getHeadings возвращает список заголовков столбцов в виде WebElement
     * @return
     */
    public List<WebElement> getHeadings() {
        WebElement headingsRow = table.findElement(By.xpath(".//tr[1]"));
        List<WebElement> headingColumns = headingsRow.findElements(By.xpath(".//th"));
        return headingColumns;
    }

    /**
     * getHeadingsWithRows возвращает список строк со списком столбцов в виде WebElement
     * @return
     */
    public List<List<WebElement>> getRowsWithColumns() {
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for(WebElement row : rows) {
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;

    }

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
