package SberInsuarance;


import SberbankInsuarance.steps.*;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import java.util.HashMap;

public class InsuaranceAllureReport extends BaseTest {

    MainSteps mainSteps = new MainSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    ProductSelectionSteps insuarancePolicyChooseSteps = new ProductSelectionSteps();
    RegistrationSteps registrationSteps = new RegistrationSteps();

    HashMap<String, String> testData = new HashMap<>();

    @Test
    @Title("Страхование")
    public void testInsuarance()  {

        driver.get(baseUrl + "/");

        testData.put("Имя застрахованного", "Петр");
        testData.put("Фамилия застрахованного", "Петров");
        testData.put("Дата рождения застрахованного", "10.07.1982");
        testData.put("Фамилия страхователя", "Иванов");
        testData.put("Имя страхователя", "Иван");
        testData.put("Отчество страхователя", "Иванович");
        testData.put("Дата рождения страхователя", "22.03.1978");
        testData.put("Серия паспорта", "4217");
        testData.put("Номер паспорта", "645249");
        testData.put("Дата выдачи", "15.09.2000");
        testData.put("Кем выдан", "УВД Красносельского района Москвы");

        mainSteps.stepSelectMainMenu("Меню  Страхование");
        mainSteps.stepSelectSubMenu("Перейти в каталог");

        catalogSteps.stepWaitSendAppClickable(driver);
        catalogSteps.checkPageTitle("Страхование для путешественников");
        catalogSteps.stepSendAppButton();

        insuarancePolicyChooseSteps.waitSendApplickable(driver);
        insuarancePolicyChooseSteps.checkoutButton();

        registrationSteps.stepFillFields(testData);
        registrationSteps.checkFillFields(testData);
        registrationSteps.stepSendAppButton();
        registrationSteps.checkErrorMessageField("alert-form-error", "При заполнении данных произошла ошибка");

    }
}
