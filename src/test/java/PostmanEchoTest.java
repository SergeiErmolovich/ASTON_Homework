import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;
    private static final String rawText = "I'm having Vietnam flashbacks from using Postman";
    private static final String name = "Dukalis";
    private static final String age = "35";

    @BeforeAll
    public static void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://postman-echo.com")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("headers.host", equalTo("postman-echo.com"))
                .expectBody("headers.x-forwarded-proto", equalTo("http"))
                .expectBody("headers.accept", equalTo("*/*"))
                .expectBody("headers.connection", equalTo("close"))
                .expectBody("headers.x-forwarded-port", equalTo("443"))
                .expectBody("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.24)"))
                .build();
    }

    @Test
    public void getRequestTest() {
        given()
                .spec(requestSpec)
                .when()
                .get("/get")
                .then()
                .spec(responseSpec)
                .body("url", equalTo("http://postman-echo.com/get"));
    }

    @Test
    public void PostRawTextTest() {
        given()
                .spec(requestSpec)
                .contentType(ContentType.TEXT)
                .body(rawText)
                .when()
                .post("/post")
                .then()
                .spec(responseSpec)
                .body("headers.content-length", equalTo(String.valueOf(rawText.length())))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("data", equalTo(rawText))
                .body("url", equalTo("http://postman-echo.com/post"));
    }

    @Test
    public void PostFormDataTest() {
        given()
                .spec(requestSpec)
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .formParam("name", name)
                .formParam("age", age)
                .when()
                .post("/post")
                .then()
                .spec(responseSpec)
                .body("form.name", equalTo(name))
                .body("form.age", equalTo(String.valueOf(age)))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=UTF-8"))
                .body("url", equalTo("http://postman-echo.com/post"));
    }

    @Test
    public void putRequestTest() {
        given()
                .spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(rawText)
                .when()
                .put("/put")
                .then()
                .spec(responseSpec)
                .body("data", equalTo(rawText))
                .body("headers.content-length", equalTo(String.valueOf(rawText.length())))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.content-type", equalTo("application/json"))
                .body("url", equalTo("http://postman-echo.com/put"));
    }

    @Test
    public void patchRequestTest() {
        given()
                .spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(rawText)
                .when()
                .patch("/patch")
                .then()
                .spec(responseSpec)
                .body("data", equalTo(rawText))
                .body("headers.content-length", equalTo(String.valueOf(rawText.length())))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.content-type", equalTo("application/json"))
                .body("url", equalTo("http://postman-echo.com/patch"));
    }

    @Test
    public void deleteRequestTest() {
        given()
                .spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(rawText)
                .when()
                .delete("/delete")
                .then()
                .spec(responseSpec)
                .body("data", equalTo(rawText))
                .body("headers.content-length", equalTo(String.valueOf(rawText.length())))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.content-type", equalTo("application/json"))
                .body("url", equalTo("http://postman-echo.com/delete"));
    }
}
