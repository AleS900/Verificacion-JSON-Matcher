package practicaComparadorJSONTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practicaComparadorJSON.JSONMatcher;

public class JSONMatcherTest {

    // Test 1: JSON Actual = JSON Esperado
    @Test
    public void verifyJSONMatcher1() throws Exception {
        String expectedJSON = "{\r\n" +
                "\"name\": \"eynar\",\r\n" +
                "\"icon\": 5,\r\n" +
                "\"deleted\": true,\r\n" +
                "\"id\": 5465456,\r\n" +
                "\"createTime\": \"IGNORE\",\r\n" +
                "\"update\": true\r\n" +
                "}";

        String actualJSON = "{\r\n" +
                "\"name\": \"eynar\",\r\n" +
                "\"icon\": 5,\r\n" +
                "\"deleted\": true,\r\n" +
                "\"id\": 5465456,\r\n" +
                "\"createTime\": \"IGNORE\",\r\n" +
                "\"update\": true\r\n" +
                "}";

        JSONMatcher matcher = new JSONMatcher();
        matcher.jsonAreEqual(expectedJSON, actualJSON, "ERROR!");
    }


    // Test 2: JSON Actual con 1 valor diferente
    @Test
    public void verifyJSONMatcher2() {
        String expectedJSON = "{\r\n" +
                "\"name\": \"eynar\",\r\n" +
                "\"icon\": 5,\r\n" +
                "\"deleted\": true,\r\n" +
                "\"id\": 5465456,\r\n" +
                "\"createTime\": \"IGNORE\",\r\n" +
                "\"update\": true\r\n" +
                "}";

        String actualJSON = "{\r\n" +
                "\"name\": \"santiago\",\r\n" +
                "\"icon\": 5,\r\n" +
                "\"deleted\": true,\r\n" +
                "\"id\": 5465456,\r\n" +
                "\"createTime\": 1545645456\r\n" +
                "}";

        JSONMatcher matcher = new JSONMatcher();
        Assertions.assertThrows(Exception.class, ()-> matcher.jsonAreEqual(expectedJSON, actualJSON, "ERROR!"));
    }


    // Test 3: JSON Actual con más de 1 valor diferente
    @Test
    public void verifyJSONMatcher3() {
        String expectedJSON = "{\r\n" +
                "\"name\": \"eynar\",\r\n" +
                "\"icon\": 5,\r\n" +
                "\"deleted\": true,\r\n" +
                "\"id\": 5465456,\r\n" +
                "\"createTime\": \"IGNORE\",\r\n" +
                "\"update\": true\r\n" +
                "}";

        String actualJSON = "{\r\n" +
                "\"name\": \"santiago\",\r\n" +
                "\"icon\": 8,\r\n" +
                "\"deleted\": true,\r\n" +
                "\"id\": 5465456,\r\n" +
                "\"createTime\": 1545645456\r\n" +
                "}";

        JSONMatcher matcher = new JSONMatcher();
        Assertions.assertThrows(Exception.class, ()-> matcher.jsonAreEqual(expectedJSON, actualJSON, "ERROR!"));
    }


    // Test 4: JSON Actual con todos los valores diferentes
    @Test
    public void verifyJSONMatcher4() {
        String expectedJSON = "{\r\n" +
                "\"name\": \"eynar\",\r\n" +
                "\"icon\": 5,\r\n" +
                "\"deleted\": true,\r\n" +
                "\"id\": 5465456,\r\n" +
                "\"createTime\": \"IGNORE\",\r\n" +
                "\"update\": true\r\n" +
                "}";

        String actualJSON = "{\r\n" +
                "\"name\": \"santiago\",\r\n" +
                "\"icon\": 10,\r\n" +
                "\"deleted\": false,\r\n" +
                "\"id\": 51442,\r\n" +
                "\"createTime\": \"10/06/00\"\r\n" +
                "}";

        JSONMatcher matcher = new JSONMatcher();
        Assertions.assertThrows(Exception.class, ()-> matcher.jsonAreEqual(expectedJSON, actualJSON, "ERROR!"));
    }


    // Test 5: JSON Actual con menos datos que JSON Esperado
    @Test
    public void verifyJSONMatcher5() {
        String expectedJSON = "{\r\n" +
                "\"name\": \"eynar\",\r\n" +
                "\"icon\": 5,\r\n" +
                "\"deleted\": true,\r\n" +
                "\"id\": 5465456,\r\n" +
                "\"createTime\": \"IGNORE\",\r\n" +
                "\"update\": true\r\n" +
                "}";

        String actualJSON = "{\r\n" +
                "}";

        JSONMatcher matcher = new JSONMatcher();
        Assertions.assertThrows(Exception.class, ()-> matcher.jsonAreEqual(expectedJSON, actualJSON, "ERROR!"));
    }


    // Test 6: JSON Esperado con menos datos que JSON Actual
    @Test
    public void verifyJSONMatcher6() {
        String expectedJSON =  "{\r\n" +
                "\"name\": \"eynar\",\r\n" +
                "\"icon\": 5,\r\n" +
                "\"deleted\": true,\r\n" +
                "\"id\": 5465456,\r\n" +
                "\"createTime\": \"IGNORE\",\r\n" +
                "}";

        String actualJSON = "{\r\n" +
                "\"name\": \"eynar\",\r\n" +
                "\"icon\": 5,\r\n" +
                "\"deleted\": true,\r\n" +
                "\"id\": 5465456,\r\n" +
                "\"createTime\": \"IGNORE\",\r\n" +
                "\"update\": true\r\n" +
                "}";

        JSONMatcher matcher = new JSONMatcher();
        Assertions.assertThrows(Exception.class, ()-> matcher.jsonAreEqual(expectedJSON, actualJSON, "ERROR!"));
    }


    // Test 7: JSON Esperado con menos datos que JSON Actual
    @Test
    public void verifyJSONMatcher7() {
        String expectedJSON = "{\r\n" +
                "\"name\": \"eynar\",\r\n" +
                "\"icon\": 5,\r\n" +
                "\"deleted\": true,\r\n" +
                "\"id\": 5465456,\r\n" +
                "\"createTime\": \"IGNORE\",\r\n" +
                "\"update\": true\r\n" +
                "}";

        String actualJSON = "";

        JSONMatcher matcher = new JSONMatcher();
        Assertions.assertThrows(Exception.class, ()-> matcher.jsonAreEqual(expectedJSON, actualJSON, "ERROR!"));
    }
}
