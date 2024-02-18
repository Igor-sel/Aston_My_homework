package org.Wildberries;

import org.Wildberries.pages.BasePage;
import org.Wildberries.pages.BasketPage;
import org.Wildberries.pages.MainPage;
import org.Wildberries.properties.CommonActions;
import org.Wildberries.properties.Config;
import org.Wildberries.properties.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = PageFactory.initElements(driver, BasePage.class);
    protected MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
    protected BasketPage basketPage = PageFactory.initElements(driver, BasketPage.class);
    protected Header header = PageFactory.initElements(driver, Header.class);
    protected SoftAssert softAssert = new SoftAssert();

    @AfterSuite(alwaysRun = true)
    public void close() {
        if (Config.QUIT_BROWSER) {
            driver.quit();
        }
    }
}