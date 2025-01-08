package Assignement_API;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Assignement_2 {
    @Test
    public void testCoinDesk() {
        RestAssured.baseURI = "https://api.coindesk.com/";
        String response = given().log().all()
                .when().get("/v1/bpi/currentprice.json")
                .then().log().all()
                .assertThat().statusCode(200)
                .body("bpi.USD", notNullValue())
                .body("bpi.GBP", notNullValue())
                .body("bpi.EUR", notNullValue())
                .body("bpi.GBP.description", equalTo("British Pound Sterling"))
                .extract().response().asString();

        System.out.println(response);
    }
}
