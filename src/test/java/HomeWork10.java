import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeWork10 {
    @ParameterizedTest
    // в такой тест будут передаваться параметры и он будет запускаться столько раз, сколько у нас есть параметров
    @ValueSource(strings = {"Hello, world","Hello, world+Hello, world"}) // наборы параметров
    public void testShortString(String name){
        Map<String, String> queryParams = new HashMap<>();


        Integer expectedName = (name.length() >15) ? 1 : 0; // тернарный оператор == однострочный if
        assertEquals(1, expectedName, "The string is too short");
    }

}

