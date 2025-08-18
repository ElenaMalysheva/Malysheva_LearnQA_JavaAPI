import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class HomeWork7 {
    @Test
    public void testRestAssure() {
        String url = "https://playground.learnqa.ru/api/long_redirect";
        int counter = 0;

        while (true) {
            Response response = RestAssured
                    .given()
                    .redirects().follow(false)
                    .when()
                    .get(url)
                    .andReturn();

            String locationHeader = response.getHeader("Location");
            int statusCode = response.getStatusCode();

            System.out.println("Redirect #" + counter + ": " + url);

            if (statusCode == 301 || statusCode == 302) {
                url = locationHeader; // переходим на следующий URL
                counter++;
            } else {
                System.out.println("Final URL: " + url);
                break;
            }
        }
    }
}

/*
Ex7: Долгий редирект
Необходимо написать тест, который создает GET-запрос на адрес из предыдущего задания: https://playground.learnqa.ru/api/long_redirect


На самом деле этот URL ведет на другой, который мы должны были узнать на предыдущем занятии. Но этот другой URL тоже куда-то редиректит. И так далее. Мы не знаем заранее количество всех редиректов и итоговый адрес.


Наша задача — написать цикл, которая будет создавать запросы в цикле, каждый раз читая URL для редиректа из нужного заголовка. И так, пока мы не дойдем до ответа с кодом 200.


Ответом должна быть ссылка на тест в вашем репозитории и количество редиректов.


 */