package org.Task1;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class Task1 {
    public static void main(String[] args) {

        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        Response response = given()
                .header("Content-Type","application/json")
                .body("{ \"username\": \"admin\", \"password\": \"password123\" }")
                .when().post("/auth");

        String token = response.jsonPath().getString("token");
        System.out.println("Token: " + token);



        String requestBody = "{ \"firstname\": \"Baraa\", \"lastname\": \"Rihan\", \"totalprice\": 100, " +
                "\"depositpaid\": true, \"bookingdates\": { \"checkin\": \"2024-04-15\", " +
                "\"checkout\": \"2024-04-16\" }, \"additionalneeds\": \"Breakfast\" }";

//Create Booking
        Response responsee = given()
                .contentType("application/json")
                .header("Authorization","Bearer " + token)
                .body(requestBody)
                .when().post("/booking");

        System.out.println("Response: " + responsee.getBody().asString());

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        int bookingId = 1; // Specify the booking ID you want to retrieve

//Get Booking
        Response responseee = given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .get("/booking/" + bookingId);

        System.out.println("Response: " + responseee.getBody().asString());
        }


    }
