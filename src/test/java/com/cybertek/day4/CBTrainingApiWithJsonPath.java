package com.cybertek.day4;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CBTrainingApiWithJsonPath {

    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://api.cybertektraining.com";

    }

    @DisplayName("GET Request to individual student")
    @Test
    public void test1(){
        //send a get request to student id 23401 as a path parameter and accept header application/json
        Response response= given().accept(ContentType.JSON)
                .pathParam("id",32881)
                .when()
                .get("/students/{id}");



        // verify status code=200
        // content type=application/json;charset=UTF-8
        // Content-Encoding = gzip

        assertEquals(200,response.statusCode());
        assertEquals("application/json;charset=UTF-8",response.contentType());

        // assertTrue("gzip",response.header(con)
       // assertTrue(response.headers().hasHeaderWithName("Accept-Encoding"));

        //verify Date header exists
        assertTrue(response.headers().hasHeaderWithName("Date"));


        //assert that
            /*
                firstName Vera
                batch 14
                section 12
                emailAddress aaa@gmail.com
                companyName Cybertek
                state IL
                zipCode 60606

                using JsonPath
             */

        JsonPath jsonPath = response.jsonPath();

        String r_firstName = jsonPath.getString("firstName");
        assertTrue(r_firstName.equals("Vera"));

        String r_batch = jsonPath.getString("batch");
        assertTrue(r_batch.equals("14"));

        String r_section = jsonPath.getString("section");
        assertTrue(r_section.equals("12"));

        String r_emailAddress = jsonPath.getString("contact.emailAddress");
        assertTrue(r_emailAddress.equals("aaa@gmail.com"));

        String r_companyName = jsonPath.getString("company.companyName");
        assertTrue(r_companyName.equals("Cybertek"));

        String r_state = jsonPath.getString("company.address.state");
        assertTrue(r_state.equals("IL"));

        String r_zipCode = jsonPath.getString("company.address.zipCode");
        assertTrue(r_zipCode.equals("60606"));






    }
}
