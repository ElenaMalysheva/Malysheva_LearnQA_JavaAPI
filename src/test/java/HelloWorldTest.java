import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

/*public class HelloWorldTest {

    @Test
    public void testHelloWorld(){
        //System.out.println("Hello World!");
        /*Response response = RestAssured
                .get("https://playground.learnqa.ru/api/hello")
                .andReturn();
        response.prettyPrint();*/

        /*Response response = RestAssured
                .get("https://playground.learnqa.ru/api/get_text")
                .andReturn();
        response.prettyPrint();

    }/*

         */



public class HelloWorldTest {

    @Test // второе занятие
    public void testRestAssure(){ // это билдер
        Map<String,String> params = new HashMap<>();
        params.put("name", "John");


        /*Response response = RestAssured //переменная, которую мы использовали в первой строке
                .given() // нужна, чтобы объяснить билдеру, что мы добавим параметры запроса
                //.queryParam("name", "John") // передали 1 параметр
                .queryParams(params)
                .get("https://playground.learnqa.ru/api/hello") // вызываем методы, это параметр/ сеттер
                .andReturn(); // это функция, исполнитель
        response.prettyPrint();*/

        JsonPath response = RestAssured
                .given()
                .queryParams(params)
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();

        //String answer = response.get("answer");
        String name = response.get("answer2"); // нет такого ключа => Null

        //System.out.println(name);

        //Добавим условие
        if (name == null){
            System.out.println("The key 'answer2' is absent"); //если ключа нет - то выводим дефолтное значение
        }else{
            System.out.println(name); // ключ есть - то выводим значение
        }

    }



}
