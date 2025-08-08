import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;



public class HelloWorldTest {

    @Test
    public void testRestAssure(){ // это билдер
        Map<String,Object> body = new HashMap<>();
        body.put("param1", "value1");
        body.put("param2", "value2");


        Response response = RestAssured
                .given()
                //.queryParam("param1", "value1")// передача параметров для get запросов
                //.queryParam("param2", "value2")
                //.body("param1=value1&param2=value2") // передача параметров в сыром виде
                //.body("{\"param1\":\"value1\",\"param2\":\"value2\"}") //строка в JSON формате
                .body(body)

                //.get("https://playground.learnqa.ru/api/check_type")
                .post("https://playground.learnqa.ru/api/check_type")

                .andReturn();



      response.print();

    }



}
