import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HomeWork8 {
    @Test
    public void testRestAssure() throws InterruptedException {
        Response response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .andReturn();



        response.prettyPrint(); // печатает JSON в удобном формате ( полностью)

        String tokenResponse = response.jsonPath().getString("token"); // запоминаем токен
        String secondsResponse = response.jsonPath().getString("seconds"); // запоминаем время
        int secondsResponseInt = Integer.parseInt(secondsResponse);
        System.out.println("токен из первого запроса = "+ tokenResponse);


        Map<String,String> cookieSecondStep = new HashMap<>();
        cookieSecondStep.put("token",tokenResponse );

        Response responseSecond = RestAssured //запрос с token ДО того, как задача готова

                .given()
                .queryParams(cookieSecondStep)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job") //
                .andReturn();

        System.out.println("Запрос без ожидания:  ");
        responseSecond.prettyPrint();
        String secondResponse = responseSecond.jsonPath().getString("status"); //
        System.out.println("Статус : " + secondResponse);


        Thread.sleep((secondsResponseInt +1) *1000); // делаем паузу

        Response responseThird = RestAssured //запрос с token после того, как задача готова

                .given()
                .queryParams(cookieSecondStep)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job") //
                .andReturn();

        System.out.println("Запрос с ожиданием ( полный ответ) :  ");
        responseThird.prettyPrint();

        String resultThird = responseThird.jsonPath().getString("result"); //
        System.out.println("Результат : " + resultThird);
        String statusThird = responseThird.jsonPath().getString("status"); //
        System.out.println("Результат : " + statusThird);


        /*
        Ex8: Токены
Иногда API-метод выполняет такую долгую задачу, что за один HTTP-запрос от него нельзя сразу получить готовый ответ. Это может быть подсчет каких-то сложных вычислений или необходимость собрать информацию по разным источникам.


В этом случае на первый запрос API начинает выполнения задачи, а на последующие ЛИБО говорит, что задача еще не готова, ЛИБО выдает результат. Сегодня я предлагаю протестировать такой метод.



Сам API-метод находится по следующему URL: https://playground.learnqa.ru/ajax/api/longtime_job



Если мы вызываем его БЕЗ GET-параметра token, метод заводит новую задачу, а в ответ выдает нам JSON со следующими полями:


* seconds - количество секунд, через сколько задача будет выполнена

* token - тот самый токен, по которому можно получить результат выполнения нашей задачи



Если же вызвать API-метод, УКАЗАВ GET-параметром token, то мы получим следующий JSON:


* error - будет только в случае, если передать token, для которого не создавалась задача. В этом случае в ответе будет следующая надпись - No job linked to this token

* status - если задача еще не готова, будет надпись Job is NOT ready, если же готова - будет надпись Job is ready

* result - будет только в случае, если задача готова, это поле будет содержать результат



Наша задача - написать тест, который сделал бы следующее:



1) создавал задачу


2) делал один запрос с token ДО того, как задача готова, убеждался в правильности поля status


3) ждал нужное количество секунд с помощью функции Thread.sleep() - для этого надо сделать import time


4) делал бы один запрос c token ПОСЛЕ того, как задача готова, убеждался в правильности поля status и наличии поля result


         */










    }
}



