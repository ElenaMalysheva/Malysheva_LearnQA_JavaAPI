import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class HomeWork7 {
    @Test
    public void testRestAssure() {
        String url = "https://playground.learnqa.ru/api/long_redirect";
        int counter = 0;

        while (true) {
            Response response = RestAssured
                    .given()
                    .redirects().follow(false)
                    .when()
                    .get(url)
                    .andReturn();

            String locationHeader = response.getHeader("Location");
            int statusCode = response.getStatusCode();

            System.out.println("Redirect #" + counter + ": " + url);

            if (statusCode == 301 || statusCode == 302) {
                url = locationHeader; // переходим на следующий URL
                counter++;
            } else {
                System.out.println("Final URL: " + url);
                break;
            }
        }
    }
}
