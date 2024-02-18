package org.Postman;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    protected Car honda = new Car("Honda", "Pilot");
    protected Car toyota = new Car("Toyota", "Land Cruiser");
    protected List<Car> cars = new ArrayList<>();

    protected RequestSpecification baseSpec = given()
            .log().body()
            .baseUri("https://postman-echo.com");

    protected ResponseSpecification statusCodeSpec = expect()
            .statusCode(200);

    public BaseTest() {
        cars.add(honda);
        cars.add(toyota);
    }
}