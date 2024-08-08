import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static java.lang.Math.log;
import static org.hamcrest.Matchers.*;

public class Get {

    @Test
    public void getListOfUsers() {
        RestAssured.given()
                .baseUri("https://reqres.in")
                .log().all()
                .basePath("/api/users")
                .queryParam("page", 2)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("data", not(empty()));
    }
}