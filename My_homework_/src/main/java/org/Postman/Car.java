package org.Postman;

public class Car {

    private final String brand;
    private final String mark;

    public Car(String brand, String mark) {
        this.brand = brand;
        this.mark = mark;
    }

    public String getBrand() {
        return brand;
    }

    public String getMark() {
        return mark;
    }
}