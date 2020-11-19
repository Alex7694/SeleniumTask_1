package SberbankInsuarance.pages;

import SberbankInsuarance.steps.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage {

    @FindBy(xpath = "//h3[text() = 'Страхование для путешественников']")
    public WebElement title;

    @FindBy(xpath = "//a[(contains(@href, 'viewCalc'))]")
    public WebElement checkOnlineBtn;

    public CatalogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Wait<WebDriver> wait = new WebDriverWait(BaseTest.getDriver(), 10, 1000);

    public void waitSendAppClickable(WebDriver driver){

        try {
            ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h3[text() = 'Страхование для путешественников']")));
            wait.until(ExpectedConditions.visibilityOf(title));
        } catch (StaleElementReferenceException ex) {
            ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h3[text() = 'Страхование для путешественников']")));
            wait.until(ExpectedConditions.visibilityOf(title));
        }
    }

    public void checkOnlineBtnClick(WebDriver driver) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(checkOnlineBtn));
            checkOnlineBtn.click();
        } catch (StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.elementToBeClickable(checkOnlineBtn));
            checkOnlineBtn.click();
        }
    }
}

