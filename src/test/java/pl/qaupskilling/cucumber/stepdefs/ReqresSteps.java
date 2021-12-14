package pl.qaupskilling.cucumber.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.qaupskilling.reqres.apis.UserAPI;
import pl.qaupskilling.reqres.entity.UserData;
import pl.qaupskilling.reqres.entity.UserResponse;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ReqresSteps {

    private Logger logger = LoggerFactory.getLogger(ReqresSteps.class);

    private final String HOST = "https://reqres.in";

    private Response resp;
    private UserAPI userApi;


    @Before
    public void featureSetUp() {
        userApi = new UserAPI(HOST);
    }

    @Given("user service is up and running")
    public void user_service_is_up_and_running() {
        logger.info("Make a health check API call or use another setup activities here!");
    }

    @When("we fetching users from page {string}")
    public void we_fetching_users_from_page(String page) {
        resp = userApi.getAllUserFromPage(page);
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
        var userAsMap = userData.asMaps(String.class, String.class).get(0);
        UserData user = createUserFromMap(userAsMap);
        resp = userApi.createUser(user);
    }

    private UserData createUserFromMap(Map<Object, Object> userAsMap) {
        return new UserData((String)userAsMap.get("name"), (String)userAsMap.get("job"));
    }

    @Then("user id have been returned in the response")
    public void userIdHaveBeenReturnedInTheResponse() {
        //String id = resp.jsonPath().get("id");
        UserResponse userResp = resp.as(UserResponse.class);
        logger.info("User id: " + userResp.getId());
        Assertions.assertNotNull(userResp.getId());
    }

    @When("we fetch user information for user id {string}")
    public void weFetchUserInformationForUserId(String userId) {
        resp = userApi.getUser(userId);
    }

    @Then("user email is {string}")
    public void userEmailIs(String expectedEmail) {
        //resp.then().assertThat().body("data.email", equalTo(expectedEmail));
        String actualEmail = resp.jsonPath().getString("data.email");
        assertThat(expectedEmail, is(equalTo(actualEmail)));
    }

    @When("we update the user with id {string} with following data:")
    public void weUpdateTheUserWithIdWithFollowingData(String id, DataTable table) {
        var newUserData = table.asMaps(String.class, String.class).get(0);
        var user = createUserFromMap(newUserData);
        resp = userApi.updateUserWithNewInformation(id, newUserData);
    }

    @Then("user job is {string}")
    public void userJobIs(String job) {
        String actualJob = resp.jsonPath().getString("job");
        logger.info("Actual user job: " + actualJob);
        Assertions.assertEquals(job, actualJob,
                "Actual user job not equal to expected one");
    }
}
