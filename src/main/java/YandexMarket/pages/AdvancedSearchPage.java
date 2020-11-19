package YandexMarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SberbankInsuarance.pages.BasePage;

public class AdvancedSearchPage extends BasePage {

    @FindBy(xpath = "//div[(text() = 'Samsung')]")
    public WebElement SamsungCheckbox;

    @FindBy(xpath = "//div[(text() = 'LG')]")
    public WebElement LgCheckbox;

    @FindBy(xpath = "//div[contains(text(), 'Beats')]")
    public WebElement BeatsCheckbox;

    @FindBy(xpath = "//a[contains(text(), 'Показать')]")
    public WebElement ShowButton;

    @FindBy(xpath = "//h4[contains(text(), 'Цена')]/../..//div[@data-prefix='от']/input")
    public WebElement priceInput;

    @FindBy(xpath = "//html/body/div[2]/section/div[2]/div/div/div[2]/div[1]")
    public WebElement TvFiltersPanel;


    public AdvancedSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName){
            case "Цена":
                fillField(priceInput, value);
                break;
            default:throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }


}
