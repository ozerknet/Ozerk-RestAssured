package com.cybertek.apiReviewEU8;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class PetStoreTest {
    String url = "https://petstore.swagger.io/v2";


    @Test
    public void T1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .queryParam("status", "available")
                .when()
                .get(url+"/pet/findByStatus");

//        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();



    }
}
