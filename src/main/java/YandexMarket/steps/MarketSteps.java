package YandexMarket.steps;

import SberbankInsuarance.steps.BaseTest;
import YandexMarket.pages.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketSteps extends BaseTest {

    @Step("Выбор пункта меню - {0}")
    public void stepSelectElectonicSection(String menuItem) {
     new MarketPage(driver).selectElectonicSection(menuItem);
    }
}
