package org.Wildberries.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class BasketPage extends BasePage {
    private List<String> productNames;
    private List<String> productPrices;
    private static class ResultWindow {
        private static final By sumLocator = By
                .xpath("//span[text()='Итого']/following-sibling::span/span");
    }

    private static class Product {
        private static final By nameLocator = By.xpath("//span[@class='good-info__good-name']");
        private static final By priceLocator = By.xpath("//div[@class='list-item__price-new']");
    }

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public BasketPage readProducts() {
        productNames = driver.findElements(Product.nameLocator)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        productPrices = driver.findElements(Product.priceLocator)
                .stream()
                .map(p -> p.getText().split("₽")[0].replaceAll("\\s", ""))
                .collect(Collectors.toList());
        return this;
    }

    public double getProductPrice(int index) {
        return Double.parseDouble(productPrices.get(index));
    }

    public String getProductName(int index) {
        return productNames.get(index);
    }

    public int getCount() {
        return productNames.size();
    }

    public double getSum() {
        return Double.parseDouble(driver.findElement(ResultWindow.sumLocator)
                .getText()
                .split("₽")[0]
                .replaceAll("\\s", ""));
    }

    public BasketPage wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
}