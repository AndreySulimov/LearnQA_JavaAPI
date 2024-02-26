package hw;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

public class Ex5 {

    @Test
    public void testEx5() {

        JsonPath response = RestAssured
            .given()
            .get("https://playground.learnqa.ru/api/get_json_homework")
            .jsonPath();

        //response.prettyPrint();

        String secondMessage = response.getString("messages[1].message");
        System.out.println(secondMessage);
    }
}
