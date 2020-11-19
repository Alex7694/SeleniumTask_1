package SberbankInsuarance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//ul[contains(@class,'kitt-top-menu')]")
    WebElement mainMenuItem;

    @FindBy(xpath = "//a[text() = 'СберСтрахование']/ancestor::div[contains(@class , 'column_3')]")
    WebElement subMenu;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void selectMainMenu(String menuItem) {
        mainMenuItem.findElement(By.xpath(".//a[@aria-label = '" + menuItem + "']")).click();
    }


    public void selectSubMenu(String menuItem) {
        subMenu.findElement(By.xpath(".//a[(text() = '" + menuItem + "')]")).click();
    }
}

