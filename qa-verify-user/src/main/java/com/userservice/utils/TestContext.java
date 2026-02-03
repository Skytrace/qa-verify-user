package com.userservice.utils;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TestContext {
    private Response response;
    private Object payload;
}
