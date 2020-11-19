package YandexMarket;

import SberbankInsuarance.steps.BaseTest;
import org.junit.Test;
import YandexMarket.pages.*;

public class HeadphonesRefactoringTest extends BaseTest {

    YandexPage yandexPage = new YandexPage(driver);
    MarketPage marketPage = new MarketPage(driver);
    ElectronicPage electronicPage = new ElectronicPage(driver);
    ProductPage productPage = new ProductPage(driver);
    AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage(driver);
    ResultSearchPage resultSearchPage = new ResultSearchPage(driver);

    @Test
    public void newMarketRefactoringTest() {

        driver.get(baseurl);

        yandexPage.selectmarketSection("Маркет");
        yandexPage.windowsHandlesManagment();

        marketPage.selectElectonicSection("Электроника");

        electronicPage.HeadphonesSection.click();

        productPage.AllfiltersBtn.click();

        advancedSearchPage.fillField("Цена", "5000");
        advancedSearchPage.BeatsCheckbox.click();
        advancedSearchPage.ShowButton.click();

        resultSearchPage.checkCountOfResultElements(19);

        resultSearchPage.fillField("Поиск", resultSearchPage.getFirstElement().getText());
        resultSearchPage.checkFillField("Первый элемент поиска", resultSearchPage.searchInput.getAttribute("value"));
    }
}
