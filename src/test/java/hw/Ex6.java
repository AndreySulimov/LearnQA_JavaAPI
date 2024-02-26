package hw;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Ex6 {

    @Test
    public void testEx6() {
        Response response = RestAssured
            .given()
            .redirects()
            .follow(false)
            .get("https://playground.learnqa.ru/api/long_redirect")
            .andReturn();

        response.prettyPrint();

        Headers responseHeaders = response.getHeaders();
        System.out.println(responseHeaders);
        String locationHeader = response.getHeader("Location");
        System.out.println(locationHeader);
    }
}
