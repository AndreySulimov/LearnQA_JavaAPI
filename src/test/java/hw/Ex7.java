package hw;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Ex7 {

    @Test
    public void testEx7() {
        String url = "https://playground.learnqa.ru/api/long_redirect";
        int statusCode = 0;
        while (statusCode != 200) {
            Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .get(url)
                .andReturn();
            statusCode = response.getStatusCode();
            url = response.getHeader("Location");
            System.out.println("Status code: " + statusCode + "; url: " + url);
        }
    }
}
