package YandexMarket.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SberbankInsuarance.pages.BasePage;

import java.util.List;

public class ResultSearchPage extends BasePage {

    @FindBy(xpath = "//span[@data-tid = 'ce80a508']")
    List<WebElement> searchResults;

    @FindBy(xpath = "//input[@placeholder= 'Искать товары и магазины']")
    public WebElement searchInput;


    public void checkCountOfResultElements(int expectedCount){
       int list = searchResults.size();
       Assert.assertEquals(expectedCount, list);
    }

    public WebElement getFirstElement() {
        return searchResults.get(0);
    }
    
    
    public ResultSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName){
            case "Поиск":
                fillField(searchInput, value);
                break;
            default:throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public void checkFillField(String fieldName, String value) {
        switch (fieldName){
            case "Первый элемент поиска":
                checkFillFields(value, getFirstElement());
                break;
            default:throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }
}
