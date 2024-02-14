package org.Wildberries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@FindBy(className = "класс_товара")
class CartPage extends BaseTest{
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<CartItem> getCartItems() {
        // Логика для получения товаров из корзины
        // Например:
        // List<WebElement> itemElements = driver.findElements(By.className("класс_товара"));
        // Пройти в цикле по элементам itemElements и создать объект CartItem для каждого товара
        return null; // Заглушка, вернуть список товаров из корзины
    }
}
/*
public class CartPage {
    // другие методы

    public List<CartItem> getItemsInCart() {
        List<CartItem> items = new ArrayList<>();
        // логика для получения списка товаров из корзины
        // например, нахождение всех карточек товаров в корзине и создание объектов CartItem
        return items;
    }
    // Получение информации о товарах в корзине в виде списка продуктов
    public List<Product> getProductsInCart() {
        List<Product> products = new ArrayList<>();
        // Логика для получения списка товаров из корзины
        // Пример добавления товаров в список:
        products.add(new Product("Название товара 1", 100.0, 2));
        products.add(new Product("Название товара 2", 50.0, 1);
        // Добавление других товаров в список
        return products;

}
 */