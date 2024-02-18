package org.Wildberries;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.Wildberries.properties.Constant.Urls.WILDBERRIES_MAIN_PAGE;

public class BasketTest extends BaseTest {

    @Test
    public void checkBasket() {
        final int COUNT = 4;
        basePage.open(WILDBERRIES_MAIN_PAGE);
        mainPage.addToBasket(COUNT);
        header.clickBasketButton();
        basketPage.wait(5000).readProducts();

        Assert.assertEquals(basketPage.getCount(), mainPage.getCountOfSelected(), "Количество товаров отличается");
        for (int i = 0; i < COUNT; i++) {
            softAssert.assertEquals(
                    basketPage.getProductName(COUNT - i - 1),
                    mainPage.getSelectedProductName(i),
                    "Наименование товаров отличается"
            );
            softAssert.assertEquals(
                    basketPage.getProductPrice(COUNT - i - 1),
                    Math.ceil(mainPage.getSelectedProductPrice(i)/97*100),
                    "Стоимость единицы товара отличается"
            );
        }
        softAssert.assertEquals(basketPage.getSum(), Math.ceil(mainPage.getSumOfSelected()/97*100),
                "Общая стоимость товаров в корзине и на главной странице различаются");
        softAssert.assertAll();
    }
}