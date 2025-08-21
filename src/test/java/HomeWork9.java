import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeWork9 {
    @Test


    public void testRestAssure() throws InterruptedException {
        List<String> passwordList = Arrays.asList(
                "123456", "123456789", "qwerty", "password", "12345",
                "12345678", "111111", "123123", "1234567", "qwerty123",
                "000000", "1q2w3e4r", "aa12345678", "abc123", "password1",
                "1234", "qwertyuiop", "admin", "letmein", "welcome",
                "monkey", "iloveyou", "123321", "1qaz2wsx", "sunshine"
        );
        for (String password : passwordList) {
            Map<String, String> data = new HashMap<>();
            data.put("login", "super_admin");
            data.put("password", password);

        Response response = RestAssured
                .given()
                .body(data)
                .when()
                .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                .andReturn();


        //response.prettyPrint(); // печатает JSON в удобном формате ( полностью)


        // Получение cookie
        String responCookie = response.getCookie("auth_cookie");
        System.out.println("auth_cookie: " + responCookie);




        //Map<String,String> cookieSecondStep = new HashMap<>();
        //cookieSecondStep.put("auth_cookie",responCookie );

        Response responseSecond = RestAssured //запрос с token ДО того, как задача готова

                .given()
                .cookie("auth_cookie", responCookie)
                .get("https://playground.learnqa.ru/ajax/api/check_auth_cookie") //
                .andReturn();

        //System.out.println("Результат второго запроса:  ");
        //responseSecond.prettyPrint();

        String secondResponse = responseSecond.asString();
            System.out.println(secondResponse);

            if (!secondResponse.contains("You are NOT authorized")) {
                System.out.println("✅ Найден правильный пароль: " + password);
                System.out.println("➡ Ответ сервера: " + secondResponse);
                break;
            } else {
                System.out.println("❌ Неправильный пароль: " + password);
            }
        }

/*
                 */





    }
}



