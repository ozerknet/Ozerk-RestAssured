package com.cybertek.day7;

import com.cybertek.pojo.Spartan;
import com.cybertek.utilities.SpartanTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Test1 extends SpartanTestBase {

    @DisplayName("GET all spartans")
    @Test
    public void test1() {

        Response response = given().accept(ContentType.JSON)
                .log().all()
                .when()
                .get("/api/spartans");

//        System.out.println("response.prettyPrint() = " + response.prettyPrint());

        System.out.println("response.statusCode() = " + response.statusCode());


    }

    @DisplayName("GET all spartans who is name = Koenraad")
    @Test
    public void test2() {

        Response response = given().accept(ContentType.JSON)
                .queryParam("nameContains", "Koenraad")
                .when()
                .get("/api/spartans/search");

        System.out.println("response.prettyPrint() = " + response.prettyPrint());


    }

    @DisplayName("GET one spartan with Path Method")
    @Test
    public void test3() {
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 10)
                .when().get("/api/spartans/{id}");
        System.out.println("response.body( = " + response.body().prettyPrint());

    }

    @DisplayName("GET request to /api/spartans/search with Query Params (MAP)")
    @Test
    public void test4() {
        //create a map and add query parameters
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("nameContains", "a");
        queryMap.put("gender", "Male");

        Response response = given().
                log().all()
                .accept(ContentType.JSON)
                .and().queryParams(queryMap)
                .when()
                .get("/api/spartans/search");

    }
// IMPORTANT NOTES from DAYs 1-7

//print response body
//      response.prettyPrint();
//verify status code
//      assertEquals(200,response.statusCode());
//verify content type
//      assertEquals("application/json",response.contentType());
//verify status code is 200
//      Assertions.assertEquals(response.statusCode(),200);
//verify content type is application/json
//      Assertions.assertEquals(response.contentType(),"application/json");
//verify json body contains Fidole
//      Assertions.assertTrue(response.body().asString().contains("Fidole"));
//verify Date header exists
//      assertTrue(response.headers().hasHeaderWithName("Date"));

    //Jsonpath
    // JsonPath jsonPath = response.jsonPath();


    //assert that all regions ids are equal to 2
    //    List<Integer> allRegionsIDs = response.path("items.region_id");

    //get the json and convert it to the map
    //    Map<String,Object> jsonMap = response.as(Map.class);

    //we need to convert json to java  which is deserialize
    //  List<Map<String,Object>> jsonList = response.as(List.class);

    ////Deserialization here JSon to Java  with Jackson objectMapper
    //        Map<String,Object> apiMap= response.as(Map.class);


}
