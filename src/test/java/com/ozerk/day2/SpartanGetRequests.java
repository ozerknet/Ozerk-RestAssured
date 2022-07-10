package com.ozerk.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartanGetRequests {

//    Given Accept type application/json
//    When user send GET request to api/spartans end point
//    Then status code must 200
//    And response Content Type must be application/json
//    And response body should include spartan result

    String baseUrl = "http://100.24.45.97:8000";

    @Test
    public void test1() {
        Response response = RestAssured.given().accept(ContentType.JSON).
                when().get(baseUrl + "/api/spartans");

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.contentType() = " + response.contentType());

        response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertEquals("application/json", response.contentType());

    }

    @DisplayName(" GET one spartan /api/spartans/3 and verify")
    @Test
    public void test2() {
        Response response = RestAssured.given().accept(ContentType.JSON).
                when().get(baseUrl + "/api/spartans/3");

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.contentType() = " + response.contentType());

        response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertEquals("application/json", response.contentType());


        System.out.println("response.body().asString() = " + response.body().asString());

        Assertions.assertTrue(response.body().asString().contains("Fidole"));



    }

    @DisplayName("GET one spartan /api/hello")
    @Test
    public void test3() {
        Response response = RestAssured.when().get(baseUrl + "/api/hello");


        Assertions.assertEquals(200,response.statusCode());

        Assertions.assertEquals("text/plain;charset=UTF-8",response.contentType());

        //verify we have headers named date
        //we use hasHeaderWithname method to verify header exist or not - it returns boolean
        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));
        //how to get and header from response using header key ?
        //we use response.header(String headerName) method to get any header value
        System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));
        System.out.println(response.header("Date"));

        //verify content length is 17
        Assertions.assertEquals("17",response.header("Content-Length"));
        //verify body is "Hello from Sparta"
        Assertions.assertEquals("Hello from Sparta",response.body().asString());



    }
}
