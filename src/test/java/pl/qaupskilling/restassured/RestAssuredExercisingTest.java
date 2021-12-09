package pl.qaupskilling.restassured;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;

public class RestAssuredExercisingTest {

    private final String HOST = "https://reqres.in";
    private final String ENDPOINT = "/api/users";
    private String QUERY = "?page=%s";

    @Test
    public void firstRestAssuredTest() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("page","2")
        .when()
                .get(HOST + ENDPOINT)
                //.get(HOST + ENDPOINT + String.format(QUERY, "2"))
        .then()
                .log()
                .body()
                .assertThat()
                .statusCode(200)
                .body(containsString("michael.lawson@reqres.in"));
    }

    @Test
    public void postRestAssuredTest() {
        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
        .when()
                .post(HOST + ENDPOINT)
        .then()
                .log()
                .body()
                .statusCode(201);
    }
}