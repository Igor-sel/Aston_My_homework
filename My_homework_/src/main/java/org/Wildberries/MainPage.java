package org.Wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseTest{
    //private final WebDriver driver;

    //@FindBy(css = "кнопка_добавить_в_корзину")
    //private WebElement addToCartButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//article[@data-nm-id='61122887']//span[@class='product-card__name']")
    private WebElement productName1;

    @FindBy(xpath = "//article[@data-nm-id='61122887']//ins[contains(@class,'lower-price')]")
    private WebElement productPrice1;

    // Добавление товара в корзину

    public String getProductName1() {
        return productName1.getText();
    }

    public String getProductPrice1() {
        return productPrice1.getText();
    }

    public void addItemsToCart() { // (String itemName)
        // Логика для добавления товара в корзину
        driver.findElement(By.xpath("//article [@data-nm-id='61122887']//a[@href='/lk/basket']")).click();

        // driver.findElement(By.linkText(itemName)).click();
        // addToCartButton.click();
    }

    public CartPage goToCart() {
        // Логика перехода в корзину
        driver.findElement(By.xpath("//div[@class='header__bottom']//a[@href='/lk/basket']")).click();
        // click.cartButton;
        //return new CartPage(driver);
        return null;
    }
}