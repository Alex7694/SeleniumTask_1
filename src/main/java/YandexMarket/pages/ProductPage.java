package YandexMarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SberbankInsuarance.pages.BasePage;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[text() = 'Все фильтры']")
    public WebElement AllfiltersBtn;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
