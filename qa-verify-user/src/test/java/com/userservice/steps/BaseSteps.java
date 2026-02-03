package com.userservice.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userservice.http.HttpClient;
import com.userservice.utils.TestContext;

public class BaseSteps {
    protected final HttpClient httpClient = new HttpClient();
    protected final ObjectMapper mapper = new ObjectMapper();
    protected final TestContext context;

    public BaseSteps(TestContext context) {
        this.context = context;
    }
}
