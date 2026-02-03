package com.userservice.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userservice.http.HttpClient;
import com.userservice.models.UserRequest;
import com.userservice.models.UserResponse;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserSteps {
    private final HttpClient httpClient = new HttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
    private Response actualResponse;

    @Given("I create a user with the following details:")
    public void createUser(DataTable table) {
        Map<String, String> data = table.asMaps(String.class, String.class).get(0);
        UserRequest request = mapper.convertValue(data, UserRequest.class);

        actualResponse = httpClient.createUser(request);
    }

    @When("I request the user by current ID")
    public void requestUserByCurrentId() {
        actualResponse = httpClient.getUser(actualResponse.as(UserResponse.class).getId());
    }

    @When("I request user with id {long}")
    public void requestUserById(Long id) {
        actualResponse = httpClient.getUser(id);
    }

    @Then("the response status should be {int}")
    public void verifyStatus(int expectedStatus) {
        assertThat("Status code mismatch!", actualResponse.statusCode(), equalTo(expectedStatus));
    }

    @Then("the response should contain the following user details:")
    public void verifyResponseDetails(DataTable table) {
        Map<String, String> expectedData = table.asMaps(String.class, String.class).get(0);

        expectedData.forEach((key, value) -> {
            String actualValue = actualResponse.jsonPath().getString(key);
            assertThat(String.format("Field '%s' mismatch!", key), actualValue, equalTo(value));
        });
    }
}