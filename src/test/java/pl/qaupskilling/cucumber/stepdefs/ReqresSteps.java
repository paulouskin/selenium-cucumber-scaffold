package pl.qaupskilling.cucumber.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ReqresSteps {

    private Logger logger = LoggerFactory.getLogger(ReqresSteps.class);

    private final String HOST = "https://reqres.in";
    private final String ENDPOINT = "/api/users";

    RequestSpecification req;
    Response resp;
    private final String SEPARATOR = "/";

    @Given("user service is up and running")
    public void user_service_is_up_and_running() {
        logger.info("Make a health check API call or use another setup activities here!");
        Cookie cookie = new Cookie.Builder("ourHomeMadeCookie","cookie1=someValue1")
                .setMaxAge(6000).build();
        req = given()
                .contentType(ContentType.JSON)
                .cookie(cookie).header("ourHomemadeHeader","ourHeaderValue");
    }

    @When("we fetching users from page {string}")
    public void we_fetching_users_from_page(String page) {
        resp = req.queryParam("page", page)
                .get(HOST + ENDPOINT).then().extract().response();
    }

    @Then("result list contains next emails:")
    public void result_list_contains_next_emails(io.cucumber.datatable.DataTable emailsTable) {
        var expectedEmails = emailsTable.asList();
        var actualEmails = resp.jsonPath().getList("data.email", String.class);
        logger.info(actualEmails.toString());
        //assertThat(actualEmails, hasItems(expectedEmails.get(0), expectedEmails.get(1)));
        assertThat(actualEmails, equalTo(expectedEmails));
    }

    @When("we create new user with following parameters:")
    public void weCreateNewUserWithFollowingParameters(DataTable userData) {
        var userAsMap = userData.asMap(String.class, String.class);
        resp = req.body(userAsMap)
                        .post(HOST + ENDPOINT).then()
                        .log().body()
                        .extract().response();
    }

    @Then("user id have been returned in the response")
    public void userIdHaveBeenReturnedInTheResponse() {
        String id = resp.jsonPath().get("id");
        logger.info("User id: " + id);
        Assertions.assertNotNull(id);
    }

    @When("we fetch user information for user id {string}")
    public void weFetchUserInformationForUserId(String userId) {
        resp = req.get(HOST + ENDPOINT + SEPARATOR + userId)
                .then().extract().response();
    }

    @Then("user email is {string}")
    public void userEmailIs(String expectedEmail) {
        //resp.then().assertThat().body("data.email", equalTo(expectedEmail));
        String actualEmail = resp.jsonPath().getString("data.email");
        assertThat(expectedEmail, is(equalTo(actualEmail)));
    }
}
