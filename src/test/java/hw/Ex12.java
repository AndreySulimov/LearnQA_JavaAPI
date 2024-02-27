package hw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.BaseTestCase;
import org.junit.jupiter.api.Test;

public class Ex12 extends BaseTestCase {

    @Test
    public void testEx12() {
        Response response = RestAssured
            .given()
            .get("https://playground.learnqa.ru/api/homework_header")
            .andReturn();

        System.out.println(response.getHeaders());

        assertEquals("Some secret value", getHeader(response, "x-secret-homework-header"),
                     "Header value is different than expected");
    }
}
