import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class Post {

    @Test
    public void createNewUser() {
        String requestBody = "{\"name\": \"Serhii\", \"job\": \"Test QA\"}";

        RestAssured.given()
                .baseUri("https://reqres.in")
                .log().all()
                .basePath("/api/users")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(201)
                .body("name", equalTo("Serhii"))
                .body("job", equalTo("Test QA"));
    }
}
