package pl.qaupskilling.cucumber.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.auth.AUTH;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.qaupskilling.cucumber.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqresSteps {

    private final String HOST = "https://reqres.in/api";
    private final String USER_SERVICE_ENDPOINT = "/users";
    private final String AUTHN_SERVICE_ENDPOINT = "/register";
    private final String SEPARATOR = "/";

    private ValidatableResponse response;

    List<String> ids = new ArrayList<>();

    Logger logger = LoggerFactory.getLogger(ReqresSteps.class);

    @Given("user service is up and running")
    public void user_service_is_up_and_running() {
        logger.info("User service is up and running");
    }

    @When("I fetch the information about user with id {int}")
    public void i_fetch_the_information_about_user_with_id(Integer id) {
        response = given().contentType(ContentType.JSON)
                .when().get(HOST + USER_SERVICE_ENDPOINT + SEPARATOR + id).then();
        response.log().body(); //.all();
    }

    @Then("user has a email {string}")
    public void user_has_a_email(String expectedEmail) {
        //response.assertThat().body("data.email", equalTo(expectedEmail));
        String actualEmail = response.extract().body().path("data.email");
        //Map<String, String> user = response.extract().body().path("data");
        Assertions.assertEquals(expectedEmail, actualEmail);
    }

    @When("I fetch all users from page {int}")
    public void iFetchAllUsersFromPage(int page) {
        response = given()
                    .contentType(ContentType.JSON).param("page", page)
                .when()
                    .get(HOST + USER_SERVICE_ENDPOINT )
                .then()
                    .log().body();
    }

    @Then("user list contains {int} users")
    public void userListContainsUsers(int numOfUsers) {
        int actualNumOfUsers = response.extract().path("per_page");
        List<Map<String, String>> users = response.extract().path("data");
        Assertions.assertEquals(numOfUsers, users.size());
    }

    @Given("the application is up and running")
    public void theApplicationIsUpAndRunning() {
        logger.info("Application is up and running");
    }

    @When("user registers with email {string} and password {string}")
    public void userRegistersWithEmailAndPassword(String email, String password) {
        Map<String, Object> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);
        response = given().contentType(ContentType.JSON).body(body)
                .when().post(HOST + AUTHN_SERVICE_ENDPOINT).then().log().body();
    }

    @Then("registration have been completed")
    public void registrationHaveBeenCompleted() {
        response.assertThat().statusCode(200);
    }

    @Then("registration have not been completed")
    public void registrationHaveNotBeenCompleted() {
        response.assertThat().statusCode(400);
    }

    @Then("registration {string} completed")
    public void registrationCompleted(String result) {
        switch (result){
            case "have been": response.assertThat().statusCode(200); break;
            case "have not been": response.assertThat().statusCode(400); break;
        }
    }

    @When("I create user with next parameters:")
    public void iCreateUserWithNextParameters(DataTable table) {
        var usersData = table.asMaps();
        createUsers(usersData);
    }

    private void createUsers(List<Map<String, String>> usersData) {
        for (Map<String, String> userData: usersData) {
            User newUser = User.fromMap(userData);
            String id = given().contentType(ContentType.JSON).body(newUser)
                    .when().post(HOST+USER_SERVICE_ENDPOINT)
                    .then().log().body().extract().path("id");
            ids.add(id);
        }
    }

    @Then("response returns user id")
    public void responseReturnsUserId() {
        Assertions.assertTrue(ids.size() > 0);
    }
}
