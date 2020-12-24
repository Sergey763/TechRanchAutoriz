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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<WebElement> rows = table.findElements(By.xpath(".//tr")); //возвращает все строки
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
        List<WebElement> rows = getRows();//список вебэлементов
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for(WebElement row : rows) {
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;

    }

    public List<Map<String, WebElement>> getRowsWithColumnsByHeadings(){
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns(); //записали список строк со списком столбцов
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowByHeadings; //одна строка разбитая на столбцы по заголовки
        List<WebElement> headingColumns = getHeadings(); // список заголовков

        for (List<WebElement> row : rowsWithColumns){
            rowByHeadings = new HashMap<String, WebElement>();
            for (int i = 0; i < headingColumns.size(); i++){
                String heading = headingColumns.get(i).getText(); //каждый список заголовков (3) например первый заголовок и
                WebElement cell = row.get(i);//первая ячейка в строке
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
    public WebElement getCell(String searchValue, int searchColumn, int returningColumn) {
        WebElement cell = null;
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        for (List<WebElement> rowWithColumns : rowsWithColumns) {
            if(rowWithColumns.get(searchColumn).getText().equals(searchValue)){

                cell = rowWithColumns.get(returningColumn);
                break;
            }
        }
        return cell;

    }

    /**
     * Возвращает true, если значение searchValue найдена в столбце searchColumn
     * @param searchValue
     * @param searchColumn
     * @return
     */
    public boolean searchCell(String searchValue, int searchColumn) {
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        boolean result = false;
        for (List<WebElement> rowWithColumns : rowsWithColumns) {
            if(rowWithColumns.get(searchColumn).getText().equals(searchValue)) {
                result =  true;
                break;
            }
        }
        return result;

    }

}
