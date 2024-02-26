package hw;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

public class Ex8 {

    @Test
    public void testEx8() throws InterruptedException {
        String url = "https://playground.learnqa.ru/ajax/api/longtime_job";

        // Step 1
        JsonPath response = RestAssured
            .given()
            .get(url)
            .jsonPath();

        response.prettyPrint();

        String token = response.getString("token");
        int time = response.getInt("seconds");

        // Step 2
        response = RestAssured
            .given()
            .queryParam("token", token)
            .get(url)
            .jsonPath();

        response.prettyPrint();
        String status = response.getString("status");

        if (status.equals("Job is NOT ready")) {
            System.out.println("Status as expected");
        } else {
            System.out.println("Incorrect status!");
        }

        // Step 3
        Thread.sleep(time * 1000L);

        // Step 4
        response = RestAssured
            .given()
            .queryParam("token", token)
            .get(url)
            .jsonPath();

        response.prettyPrint();

        status = response.getString("status");
        String result = response.getString("result");

        if (status.equals("Job is ready") && result != null) {
            System.out.println("OK!");
        } else {
            System.out.println("Incorrect status or result!");
        }
    }
}