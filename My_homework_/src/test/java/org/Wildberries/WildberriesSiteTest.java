package org.Wildberries;

import org.testng.annotations.Test;

import java.util.List;

public class WildberriesSiteTest extends BaseTest{
    @Test
    public void testCartItems() {
    MainPage mainPage = new MainPage(driver);
    mainPage.addItemsToCart(); // "первый_товар_для_добавления" (в скобках)
    mainPage.addItemsToCart(); // "второй_товар_для_добавления" (в скобках)
    mainPage.addItemsToCart();



    CartPage cartPage = mainPage.goToCart();
    List<CartItem> cartItems = cartPage.getCartItems();

    // Проверки на соответствие
    //Assert.assertEquals(cartItems.get(0).getName(), "ожидаемое_название_первого_товара");

    // Другие проверки...
    }
}