package com.cybertek.apiReviewEU8;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class ZipBase {

    @BeforeAll
    public static void init(){
        baseURI = "http://api.zippopotam.us";
        basePath ="/us";
    }
}
