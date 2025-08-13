import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;



public class HelloWorldTest {

    @Test
    public void testRestAssure(){ // это билдер
        //Map<String,Object> body = new HashMap<>();
        //body.put("param1", "value1");
        //body.put("param2", "value2");


        Response response = RestAssured
                .given()
                .redirects()
                //.follow(false) // ответ == 303
                .follow(true) // ответ == 200 система пошла по новому юрл и получила ответ 200

                .when()

                //.queryParam("param1", "value1")// передача параметров для get запросов
                //.queryParam("param2", "value2")
                //.body("param1=value1&param2=value2") // передача параметров в сыром виде
                //.body("{\"param1\":\"value1\",\"param2\":\"value2\"}") //строка в JSON формате
                //.body(body)

                //.get("https://playground.learnqa.ru/api/check_type") //получаем ответ 200
                //.get("https://playground.learnqa.ru/api/get_500")//получаем ответ 500
                //.get("https://playground.learnqa.ru/api/something") //получаем ответ 404
                .get("https://playground.learnqa.ru/api/get_303") //получаем ответ 303
                .andReturn()



                //.post("https://playground.learnqa.ru/api/check_type")

                .andReturn();

        int statusCode = response.statusCode();
        System.out.println(statusCode);
        //response.print();

    }



}
