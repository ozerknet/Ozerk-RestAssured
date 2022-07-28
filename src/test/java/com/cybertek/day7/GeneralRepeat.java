package com.cybertek.day7;

import com.cybertek.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneralRepeat {
    String url = "http://100.24.45.97:8000/api/spartans";

    @DisplayName("Send a basic GET request")
    @Test
    public void test1() {
        //send a get request and save response inside the Response object
        Response response = RestAssured.get(url);


        //print response status code
        System.out.println(response.statusCode());

        //print response body
        response.prettyPrint();
    }

    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = ConfigurationReader.getProperty("ordsBaseUrl");  // -> http://100.24.45.97:1000/ords/hr
    }

    @DisplayName("Send a besic GET request with 'baseURI' ")
    @Test
    public void Test2(){

        Response response = get("/regions");
        System.out.println("response.contentType() = " + response.contentType());
        //print the status code
        System.out.println(response.statusCode());

    }
    @DisplayName("GET request to /regions/2")
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/regions/2");

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());
        response.prettyPrint();
        assertTrue(response.body().asString().contains("Americas"));

    }






}
