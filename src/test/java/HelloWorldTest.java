import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

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
        Response response = RestAssured //переменная, которую мы использовали в первой строке
                .get("https://playground.learnqa.ru/api/hello") // вызываем методы, это параметр/ сеттер
                .andReturn(); // это функция, исполнитель
        response.prettyPrint();

    }



}
