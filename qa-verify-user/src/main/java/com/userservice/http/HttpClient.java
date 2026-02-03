package com.userservice.http;

import com.userservice.models.UserRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class HttpClient {
    private final RequestSpecification spec;
    private static final String USERS_ENDPOINT = "/users";

    public HttpClient() {
        this.spec = given()
                .baseUri("https://reqres.in")
                .basePath("/api")
                .contentType(ContentType.JSON)
                .header("x-api-key", "pub_b64ef190c3804a02aeee2e7b72b37f119c86b58546ee8d0e9822387bcbeaacbe")
                .log().all();
    }

    public Response createUser(UserRequest request) {
        return given()
                .spec(spec)
                .body(request)
                .post(USERS_ENDPOINT);
    }

    public Response getUser(long id) {
        return given()
                .spec(spec) // И здесь тоже
                .pathParam("id", id)
                .get(USERS_ENDPOINT + "/{id}");
    }
}