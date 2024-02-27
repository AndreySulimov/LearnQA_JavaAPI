package hw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.BaseTestCase;
import org.junit.jupiter.api.Test;

public class Ex11 extends BaseTestCase {

    @Test
    public void testEx11() {
        Response response = RestAssured
            .given()
            .get("https://playground.learnqa.ru/api/homework_cookie")
            .andReturn();

        System.out.println(response.getHeaders());

        assertEquals("hw_value", getCookie(response, "HomeWork"),
                     "Cookie value is different than expected");
    }
}
