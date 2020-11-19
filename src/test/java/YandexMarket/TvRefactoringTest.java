package YandexMarket;

import SberbankInsuarance.steps.BaseTest;
import org.junit.Test;
import YandexMarket.pages.*;

public class TvRefactoringTest extends BaseTest {

    YandexPage yandexPage = new YandexPage(driver);
    MarketPage marketPage = new MarketPage(driver);
    ProductPage productPage = new ProductPage(driver);
    AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage(driver);
    ResultSearchPage resultSearchPage = new ResultSearchPage(driver);

    @Test
    public void newMarketRefactoringTest() {
        driver.get(baseurl);

        yandexPage.selectmarketSection("Маркет");
        yandexPage.windowsHandlesManagment();

        marketPage.selectElectonicSection("Электроника");

        ElectronicPage electronicPage = new ElectronicPage(driver);
        electronicPage.TvSection.click();

        productPage.AllfiltersBtn.click();

        advancedSearchPage.fillField("Цена", "20000");
        advancedSearchPage.SamsungCheckbox.click();
        advancedSearchPage.LgCheckbox.click();
        advancedSearchPage.ShowButton.click();

        resultSearchPage.checkCountOfResultElements(48);
        resultSearchPage.fillField("Поиск", resultSearchPage.getFirstElement().getText());
        resultSearchPage.checkFillField("Первый элемент поиска", resultSearchPage.searchInput.getAttribute("value"));
    }
}
