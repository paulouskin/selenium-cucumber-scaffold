package pl.qaupskilling.reqres.apis;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pl.qaupskilling.reqres.entity.UserData;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserAPI {

    private final String ENDPOINT = "/api/users";
    private final String SEPARATOR = "/";

    private String host;
    private RequestSpecification req;

    public UserAPI(String host) {
        this.host = host;
    }

    private void configureRequest() {
        Cookie cookie = new Cookie.Builder("ourHomeMadeCookie","cookie1=someValue1")
                .setMaxAge(6000).build();
        req = given()
                .contentType(ContentType.JSON)
                .cookie(cookie).header("ourHomemadeHeader","ourHeaderValue");
    }

    public Response getAllUserFromPage(String page) {
        configureRequest();
        return req.queryParam("page", page).get(host + ENDPOINT).then().extract().response();
    }

    public Response createUser(Map<Object, Object> userAsMap) {
        configureRequest();
        return req.body(userAsMap)
                .post(host + ENDPOINT).then()
                .log().body()
                .extract().response();
    }

    public Response getUser(String userId) {
        configureRequest();
        return req.get(host + ENDPOINT + SEPARATOR + userId)
                .then().extract().response();
    }

    public Response updateUserWithNewInformation(String id, Map<Object, Object> newUserData) {
        configureRequest();
        return req.body(newUserData).put(host + ENDPOINT + SEPARATOR + id)
                .then().extract().response();
    }

    public Response createUser(UserData user) {
        configureRequest();
        return req.body(user)
                .post(host + ENDPOINT).then()
                .log().body()
                .extract().response();
    }
}
