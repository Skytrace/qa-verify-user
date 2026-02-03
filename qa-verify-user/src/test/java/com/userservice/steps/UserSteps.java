package com.userservice.steps;

import com.userservice.models.UserRequestDTO;
import com.userservice.models.UserResponseDTO;
import com.userservice.utils.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserSteps extends BaseSteps {

    public UserSteps(TestContext context) {
        super(context);
    }

    @Given("I create a user with the following details:")
    public void createUser(DataTable table) {
        Map<String, String> data = table.asMaps(String.class, String.class).get(0);
        UserRequestDTO request = mapper.convertValue(data, UserRequestDTO.class);

        context.setResponse(httpClient.createUser(request));
    }

    @When("I request the user by current ID")
    public void requestUserByCurrentId() {
        Long id = context.getResponse().as(UserResponseDTO.class).getId();
        context.setResponse(httpClient.getUser(id));
    }

    @When("I request user with id {long}")
    public void requestUserById(Long id) {
        context.setResponse(httpClient.getUser(id));
    }

    @Then("the response status should be {int}")
    public void verifyStatus(int expectedStatus) {
        assertThat("Status code is not as expected!",
                context.getResponse().statusCode(), equalTo(expectedStatus));
    }

    @Then("the response should contain the following user details:")
    public void verifyResponseDetails(DataTable table) {
        Map<String, String> expectedData = table.asMaps(String.class, String.class).get(0);

        expectedData.forEach((key, value) -> {
            String actualValue = context.getResponse().jsonPath().getString(key);
            assertThat(String.format("Field '%s' is not as expected!", key),
                    actualValue, equalTo(value));
        });
    }
}