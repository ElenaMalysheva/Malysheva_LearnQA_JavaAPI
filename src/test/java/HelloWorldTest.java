import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import io.restassured.http.Headers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HelloWorldTest {

    @Test
    public void testFor200(){ // это билдер

        Response response = RestAssured
                .get ("https://playground.learnqa.ru/api/map") //
                .andReturn();
        //assertTrue(response.statusCode()==200, "unexpected status code"); //проверяет булевое значение
        assertEquals(200, response.statusCode(), "unexpected status code"); //увидим ожидаемое и фактическое значение
        }

    @Test
    public void testFor404() { // это билдер

        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/map2") //
                .andReturn();
        assertEquals(404, response.statusCode(), "unexpected status code");
    }


    }
