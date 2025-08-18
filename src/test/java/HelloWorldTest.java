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
        Map<String,Object> data = new HashMap<>();


        data.put("login", "secret_login2"); //задачем параметры
        data.put("password", "secret_pass2 ");



        Response responseForGet = RestAssured
                .given()
                //.headers(headers)
                .body(data)
                .when()
                .post ("https://playground.learnqa.ru/api/get_auth_cookie") //

                .andReturn();

        String responseCookie = responseForGet.getCookie("auth_cookie");

        Map<String,String> cookies = new HashMap<>();

        if (responseCookie != null){
            cookies.put("auth_cookie",responseCookie);
        }

        Response responseForCheck = RestAssured
                .given()
                .body(data)
                .cookies(cookies)
                .when()
                .post("https://playground.learnqa.ru/api/check_auth_cookie")
                .andReturn();

        responseForCheck.print();

        /* System.out.println("\nPretty text:"); // печатаем полный ответ ( будет пустым)
        response.prettyPrint();

        System.out.println("\nHeaders:");
        Headers responseHeaders = response.getHeaders();
        System.out.println(responseHeaders); // печатаем все хедерс

        System.out.println("\nCookies:");
        Map<String,String> responseCookies = response.getCookies();
        System.out.println(responseCookies); // печатаем куки */

        //String responseCookie = response.getCookie("auth_cookie");
        //System.out.println(responseCookie); // вывод только куки





    }

}
