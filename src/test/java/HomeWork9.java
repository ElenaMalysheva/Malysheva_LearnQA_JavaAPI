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
        for (String password : passwordList) { // запускаем цикл
            Map<String, String> data = new HashMap<>();
            data.put("login", "super_admin"); // объявляем переменные
            data.put("password", password);

        Response response = RestAssured // первый запрос для получения куки
                .given()
                .body(data)
                .when()
                .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                .andReturn();


        // Сохраняем и печатаем cookie
        String responCookie = response.getCookie("auth_cookie");
        System.out.println("auth_cookie: " + responCookie);


        Response responseSecond = RestAssured //Второй запрос, с использованием куки

                .given()
                .cookie("auth_cookie", responCookie)
                .get("https://playground.learnqa.ru/ajax/api/check_auth_cookie") //
                .andReturn();


        String secondResponse = responseSecond.asString(); // записываем и печатаем результат запроса
            System.out.println(secondResponse);

            if (!secondResponse.contains("You are NOT authorized")) { // ищем условие и прерываем цикл при его выполнении
                System.out.println("✅ Найден правильный пароль: " + password);
                System.out.println("➡ Ответ сервера: " + secondResponse);
                break;
            } else {
                System.out.println("❌ Неправильный пароль: " + password);
            }
        }

/*
Ex9: Подбор пароля
Сегодня к нам пришел наш коллега и сказал, что забыл свой пароль от важного сервиса. Он просит нас помочь ему написать программу, которая подберет его пароль.



Условие следующее. Есть метод: https://playground.learnqa.ru/ajax/api/get_secret_password_homework


Его необходимо вызывать POST-запросом с двумя параметрами: login и password



Если login указан и существует, метод вернет нам авторизационную cookie с названием auth_cookie и каким-то значением.


У метода существует защита от перебора. Если верно указано поле login, но передан неправильный password, то авторизационная cookie все равно вернется. НО с "неправильным" значением, которое на самом деле не позволит создавать авторизованные запросы. Только если и login, и password указаны верно, вернется cookie с "правильным" значением. Таким образом используя только метод get_secret_password_homework невозможно узнать, передали ли мы верный пароль или нет.



По этой причине нам потребуется второй метод, который проверяет правильность нашей авторизованной cookie: https://playground.learnqa.ru/ajax/api/check_auth_cookie



Если вызвать его без cookie с именем auth_cookie или с cookie, у которой выставлено "неправильное" значение, метод вернет фразу "You are NOT authorized".


Если значение cookie “правильное”, метод вернет: “You are authorized”


Коллега говорит, что точно помнит свой login - это значение super_admin



А вот пароль забыл, но точно помнит, что выбрал его из списка самых популярных паролей на Википедии (вот тебе и супер админ...).


Ссылка: https://en.wikipedia.org/wiki/List_of_the_most_common_passwords

Искать его нужно среди списка Top 25 most common passwords by year according to SplashData - список паролей можно скопировать в ваш тест вручную или придумать более хитрый способ, если сможете.



Итак, наша задача - написать тест и указать в нем login нашего коллеги и все пароли из Википедии в виде списка. Программа должна делать следующее:


1. Брать очередной пароль и вместе с логином коллеги вызывать первый метод get_secret_password_homework. В ответ метод будет возвращать авторизационную cookie с именем auth_cookie и каким-то значением.


2. Далее эту cookie мы должна передать во второй метод check_auth_cookie. Если в ответ вернулась фраза "You are NOT authorized", значит пароль неправильный. В этом случае берем следующий пароль и все заново. Если же вернулась другая фраза - нужно, чтобы программа вывела верный пароль и эту фразу.


Ответом к задаче должен быть верный пароль и ссылка на коммит со скриптом.


                 */





    }
}



