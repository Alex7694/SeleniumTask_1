package SberInsuarance;

import org.junit.Test;
import SberbankInsuarance.pages.CatalogPage;
import SberbankInsuarance.pages.MainPage;
import SberbankInsuarance.pages.ProductSelectionPage;
import SberbankInsuarance.pages.RegistrationPage;
import SberbankInsuarance.steps.BaseTest;

import static org.junit.Assert.assertTrue;

public class InsuaranceRefactoringTest extends BaseTest {

    @Test
    public void newInsuaranceTest() {
        driver.get(baseUrl + "/");
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Меню  Страхование");
        mainPage.selectSubMenu("Перейти в каталог");

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.waitSendAppClickable(driver);
        String actualTitle = catalogPage.title.getText();
        String expectedTitle = "Страхование для путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
        catalogPage.checkOnlineBtnClick(driver);

        ProductSelectionPage productSelectionPage = new ProductSelectionPage(driver);
        productSelectionPage.waitSendAppClickable(driver);
        productSelectionPage.checkoutBtn.click();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillField("Имя застрахованного", "Петр");
        registrationPage.fillField("Фамилия застрахованного", "Петров");
        registrationPage.fillField("Дата рождения застрахованного", "10.07.1982");

        registrationPage.citizenship.click();

        registrationPage.fillField("Фамилия страхователя", "Иванов");
        registrationPage.fillField("Имя страхователя", "Иван");
        registrationPage.fillField("Отчество страхователя", "Иванович");
        registrationPage.fillField("Дата рождения страхователя", "22.03.1978");

        registrationPage.citizenship.click();

        registrationPage.fillField("Серия паспорта", "4217");
        registrationPage.fillField("Номер паспорта", "645249");
        registrationPage.fillField("Дата выдачи", "15.09.2000");

        registrationPage.person_middleName.click();

        registrationPage.fillField("Кем выдан", "УВД Красносельского района Москвы");
        registrationPage.checkFillField("Имя застрахованного", "Петр");
        registrationPage.checkFillField("Фамилия застрахованного", "Петров");
        registrationPage.checkFillField("Дата рождения застрахованного", "10.07.1982");
        registrationPage.checkFillField("Фамилия страхователя", "Иванов");
        registrationPage.checkFillField("Имя страхователя", "Иван");
        registrationPage.checkFillField("Отчество страхователя", "Иванович");
        registrationPage.checkFillField("Дата рождения страхователя", "22.03.1978");
        registrationPage.checkFillField("Серия паспорта", "4217");
        registrationPage.checkFillField("Номер паспорта", "645249");
        registrationPage.checkFillField("Дата выдачи", "15.09.2000");

        registrationPage.continueButton.click();

        registrationPage.checkFieldErrorMessage("alert-form-error", "При заполнении данных произошла ошибка");
    }
}
