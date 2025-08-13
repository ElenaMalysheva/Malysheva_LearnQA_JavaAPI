import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

public class HomeWork6 {
    @Test
    public void testRestAssure(){
        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .jsonPath();


        System.out.println("Это полный текст JSON");
        String fullanswer = response.prettyPrint(); // выводим полный джейсон

    }
}



