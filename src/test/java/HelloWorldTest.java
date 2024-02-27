import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {

    @Test
    public void testRestAssured() {
        Map<String, String> headers = new HashMap<>();
        headers.put("myHeader1", "value1");
        headers.put("myHeader2", "value2");

        Response response = RestAssured
            .given()
            .get("https://playground.learnqa.ru/api/map2")
            .andReturn();

        assertEquals(200, response.statusCode(), "Unexpected status code");
        response.prettyPrint();

        Headers responseHeaders = response.getHeaders();
        System.out.println(responseHeaders);
    }
}
