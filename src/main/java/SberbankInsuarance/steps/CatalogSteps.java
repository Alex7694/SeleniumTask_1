package SberbankInsuarance.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import SberbankInsuarance.pages.CatalogPage;
import ru.yandex.qatools.allure.annotations.Step;

public class CatalogSteps extends BaseTest {

    @Step("на странице есть заголовок - равный {0}")
    public void checkPageTitle(String expectedTitle) {
        CatalogPage catalogPage = new CatalogPage(driver);
        String actualTitle = catalogPage.title.getText();
        Assert.assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("нажатие на кнопку Оформить онлайн")
    public void stepSendAppButton() {
        new CatalogPage(driver).checkOnlineBtnClick(driver);
    }

    @Step("Ожидание загрузки страницы")
    public void stepWaitSendAppClickable(WebDriver webDriver) {
        new CatalogPage(driver).waitSendAppClickable(driver);
    }
}


