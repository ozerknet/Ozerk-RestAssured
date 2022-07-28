package com.cybertek.day2;

import com.cybertek.utilities.ConfigurationReader;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;

public class P1 {

    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = ConfigurationReader.getProperty("ordsMyBaseUrl");
    }


    @DisplayName("GET request to /regions")
    @Test
    public void test1(){
        
        Response response = get("/regions");

        System.out.println("response.statusCode() = " + response.statusCode());
        
        
        
    }
}
