import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;



public class HomeWork5 {
    @Test
    public void testRestAssure(){
        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();


        System.out.println("Это полный текст JSON");
        String fullanswer = response.prettyPrint(); // выводим полный джейсон
        String message = response.getString("messages[1].message");
        System.out.println("Второе сообщение в JSON: " + message); // вывод второго сообщения
    }
}

/*
В рамках этой задачи нужно создать тест, который будет делать GET-запрос на адрес https://playground.learnqa.ru/api/get_json_homework


Полученный JSON необходимо распечатать и изучить. Мы увидим, что это данные с сообщениями и временем, когда они были написаны. Наша задача вывести текст второго сообщения.


 */
