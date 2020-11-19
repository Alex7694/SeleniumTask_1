package SberbankInsuarance.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SberbankInsuarance.steps.BaseTest;
import ru.yandex.qatools.allure.annotations.Attachment;


public class RegistrationPage extends BasePage {

    private static Object driver;

    @FindBy(id = "name_vzr_ins_0")
    public WebElement name;

    @FindBy(id = "surname_vzr_ins_0")
    public WebElement surname;

    @FindBy(id = "birthDate_vzr_ins_0")
    public WebElement birthDate;

    @FindBy(xpath = "//label[text()= 'гражданин РФ']")
    public WebElement citizenship;

    @FindBy(id = "person_lastName")
    public WebElement person_lastName;

    @FindBy(id = "person_firstName")
    public WebElement person_firstName;

    @FindBy(id = "person_middleName")
    public WebElement person_middleName;

    @FindBy(id = "person_birthDate")
    public WebElement person_birthDate;

    @FindBy(id = "passportSeries")
    public WebElement passportSeries;

    @FindBy(id = "passportNumber")
    public WebElement passportNumber;

    @FindBy(id = "documentDate")
    public WebElement documentDate;

    @FindBy(id = "documentIssue")
    public WebElement documentIssue;

    @FindBy(xpath = "//label[text()= 'Мужской']")
    public WebElement sexSelection;

    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    public WebElement continueButton;


    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void fillField(String fieldName, String value) {
        switch (fieldName){
            case "Имя застрахованного":
                fillField(name, value);
                break;
            case  "Фамилия застрахованного":
                fillField(surname, value);
                break;
            case "Дата рождения застрахованного":
                fillField(birthDate, value);
                break;
            case "Гражданство":
                fillField(citizenship, value);
                break;
            case "Фамилия страхователя":
                fillField(person_lastName, value);
                break;
            case "Имя страхователя":
                fillField(person_firstName, value);
                break;
            case "Отчество страхователя":
                fillField(person_middleName, value);
                break;
            case "Дата рождения страхователя":
                fillField(person_birthDate, value);
                break;
            case "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case "Номер паспорта":
                fillField(passportNumber, value);
                break;
            case "Дата выдачи":
                fillField(documentDate, value);
                break;
            case "Кем выдан":
                fillField(documentIssue, value);
                break;
            default:throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public void checkFillField(String fieldName, String value) {
        switch (fieldName){
            case "Имя застрахованного":
                checkFillField(value, name);
                break;
            case  "Фамилия застрахованного":
                checkFillField(value, surname);
                break;
            case "Дата рождения застрахованного":
                checkFillField(value, birthDate);
                break;
            case "Гражданство":
                checkFillField(value, citizenship);
                break;
            case "Фамилия страхователя":
                checkFillField(value, person_lastName);
                break;
            case "Имя страхователя":
                checkFillField(value, person_firstName);
                break;
            case "Отчество страхователя":
                checkFillField(value, person_middleName);
                break;
            case "Дата рождения страхователя":
                checkFillField(value, person_birthDate);
                break;
            case "Серия паспорта":
                checkFillField(value, passportSeries);
                break;
            case "Номер паспорта":
                checkFillField(value, passportNumber);
                break;
            case "Дата выдачи":
                checkFillField(value, documentDate);
                break;
            case "Кем выдан":
                checkFillField(value, documentIssue);
                break;
            default:throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }


    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Имя застрахованного":
                return name.getAttribute("value");
            case  "Фамилия застрахованного":
                return surname.getAttribute("value");
            case  "Дата рождения застрахованного":
                return birthDate.getAttribute("value");
            case  "Гражданство":
                return citizenship.getAttribute("value");
            case  "Фамилия страхователя":
                return person_lastName.getAttribute("value");
            case  "Имя страхователя":
                return person_firstName.getAttribute("value");
            case  "Отчество страхователя":
                return person_middleName.getAttribute("value");
            case  "Дата рождения страхователя":
                return person_birthDate.getAttribute("value");
            case  "Серия паспорта":
                return passportSeries.getAttribute("value");
            case  "Номер паспорта":
                return passportNumber.getAttribute("value");
            case  "Дата выдачи":
                return documentDate.getAttribute("value");
            case  "Кем выдан":
                return documentIssue.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }


    public void checkFieldErrorMessage(String field, String errorMessage) {
        String xpath = "//div[contains(@class , '"+ field +"')]";
        String actualValue = BaseTest.getDriver().findElement(By.xpath(xpath)).getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }


    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

