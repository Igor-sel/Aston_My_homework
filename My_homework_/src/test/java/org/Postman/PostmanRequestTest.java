package org.Postman;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanRequestTest extends BaseTest {

    @Test
    public void requestGetTest() {
        baseSpec
                .given()
                .queryParam ("Honda", "Pilot")
                .queryParam("Toyota", "Land Cruiser")
                .when()
                .get("/get")
                .then()
                .spec(statusCodeSpec)
                .body("args.Honda", equalTo("Pilot"))
                .body("args.Toyota", equalTo("Land Cruiser"));
    }

    @Test
    public void requestPostTest() {
        given()
                .spec(baseSpec)
                .contentType("application/json")
                .body(cars)
                .when()
                .post("/post")
                .then()
                .body("json[0].brand", equalTo(honda.getBrand()))
                .body("json[0].mark", equalTo(honda.getMark()))
                .and()
                .body("json[1].brand", equalTo(toyota.getBrand()))
                .body("json[1].mark", equalTo(toyota.getMark()))
                .spec(statusCodeSpec);
    }

    @Test
    public void requestPutTest() {
        given()
                .spec(baseSpec)
                .contentType("application/json")
                .body(cars)
                .when()
                .put("/put")
                .then()
                .body("json[0].brand", equalTo(honda.getBrand()))
                .body("json[0].mark", equalTo(honda.getMark()))
                .and()
                .body("json[1].brand", equalTo(toyota.getBrand()))
                .body("json[1].mark", equalTo(toyota.getMark()))
                .spec(statusCodeSpec);
    }

    @Test
    public void requestPatchTest() {
        given()
                .spec(baseSpec)
                .contentType("application/json")
                .body(cars)
                .when()
                .patch("/patch")
                .then()
                .body("json[0].brand", equalTo(honda.getBrand()))
                .body("json[0].mark", equalTo(honda.getMark()))
                .and()
                .body("json[1].brand", equalTo(toyota.getBrand()))
                .body("json[1].mark", equalTo(toyota.getMark()))
                .spec(statusCodeSpec);
    }

    @Test
    public void requestDeleteTest()  {
        given()
                .spec(baseSpec)
                .contentType("application/json")
                .body(cars)
                .when()
                .delete("/delete")
                .then()
                .body("json[0].brand", equalTo(honda.getBrand()))
                .body("json[0].mark", equalTo(honda.getMark()))
                .and()
                .body("json[1].brand", equalTo(toyota.getBrand()))
                .body("json[1].mark", equalTo(toyota.getMark()))
                .spec(statusCodeSpec);
    }
}