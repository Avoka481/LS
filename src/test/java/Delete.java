import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class Delete {

    @Test
    public void deleteUser() {
        RestAssured.given()
                .baseUri("https://reqres.in")
                .log().all()
                .basePath("/api/users/2")
                .when()
                .delete()
                .then()
                .log().all()
                .statusCode(204);
    }
}
