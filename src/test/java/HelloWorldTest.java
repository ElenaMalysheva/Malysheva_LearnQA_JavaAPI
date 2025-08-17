import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import io.restassured.http.Headers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;



public class HelloWorldTest {

    @Test
    public void testRestAssure(){ // это билдер
        Map<String,Object> headers = new HashMap<>();
        headers.put("myHeader1", "myValue1"); //задачем параметры
        headers.put("myHeader2", "myValue2");



        Response response = RestAssured
                .given()
                //.headers(headers)
                .redirects()
                .follow(false)
                .when()
                //.get("https://playground.learnqa.ru/api/show_all_headers") //получаем ответ 303
                .get("https://playground.learnqa.ru/api/get_303") //получаем ответ 303

                .andReturn();

        response.prettyPrint(); // печатает JSON в удобном формате ( полностью)

        //Headers responseHeaders = response.getHeaders();//печатаем все заголовки
        String locationHeader = response.getHeader("Location");
        System.out.println(locationHeader);



    }

}
