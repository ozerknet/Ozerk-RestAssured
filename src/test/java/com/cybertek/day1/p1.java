package com.cybertek.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class p1 {

    String url = "http://100.24.45.97:8000/api/spartans";

    @Test
    public void test1(){

        Response response = RestAssured.get(url);


        System.out.println("response.statusCode() = " + response.statusCode());

//        System.out.println("response.prettyPrint() = " + response.prettyPrint());

        System.out.println("response.headers() = " + response.headers());

//        System.out.println("response.asPrettyString() = " + response.asPrettyString());

//        System.out.println("response = " + response.body().prettyPrint());
    }

















}
