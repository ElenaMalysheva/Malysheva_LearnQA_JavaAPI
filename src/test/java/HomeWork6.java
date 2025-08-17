import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class HomeWork6 {
    @Test
    public void testRestAssure(){
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")

                .andReturn();
        String locationHeader = response.getHeader("Location");
        System.out.println("Первый адрес для редиректа = "+ locationHeader);


        response.prettyPrint(); // печатает JSON в удобном формате ( полностью)

    }
}



