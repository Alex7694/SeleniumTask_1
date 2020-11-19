package YandexMarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SberbankInsuarance.pages.BasePage;

public class ElectronicPage extends BasePage {

    @FindBy(xpath = "//a[text() = 'Телевизоры' and  contains(@class, '2x2zBaVN-3')]")
    public WebElement TvSection;

    @FindBy(xpath = "//a[contains(text(), 'Наушники и Bluetooth-гарнитуры')]")
    public WebElement HeadphonesSection;

    public ElectronicPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
