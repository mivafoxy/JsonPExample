import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class Main {
/*
{"name": "John", "age": 26, "is_married": false, "children": [{ "name": "Julia", "age": null}],"skills": ["Python", "Git", "Django", "Linux"]}
 */
// см. https://jsonformatter.org/
    /*
    {
      "name": "John",
      "age": 26,
      "is_married": false,
      "children": [
        {
          "name": "Julia",
          "age": 14
        }
      ],
      "skills": [
        "Python",
        "Git",
        "Django",
        "Linux"
      ]
    }
     */
    public static String jsonString =
        "{\n" +
            "  \"name\": \"John\",\n" +
            "  \"age\": 26,\n" +
            "  \"is_married\": false,\n" +
            "  \"children\": [\n" +
            "    {\n" +
            "      \"name\": \"Julia\",\n" +
            "      \"age\": 14\n" +
            "    }\n" +
            "  ],\n" +
            "  \"skills\": [\n" +
            "    \"Python\",\n" +
            "    \"Git\",\n" +
            "    \"Django\",\n" +
            "    \"Linux\"\n" +
            "  ]\n" +
            "}";

    public static void main(String[] args) {
        /* Пример json объекта
        {
          "name": "John",
          "age": 26
        }
        {"name":"John","age":26}
         */

        /* Пример json массивов
        - Цифры: [1, 5, 10, 33]
        - Строки: ["MALE", "FEMALE"]
        - Литералы: [true, false]
        - Массивы: ["MALE", "FEMALE", [1, 5, 10, 33]]
        - Объекты: [{"name":"John","age":26}, {"name":"Alice","age":30}]
        - Смесь всего этого вместе: [1, "John", true, [1, 5, 10, 33], {"a": 1, "b": 2}]

         */

        /* СЕГОДНЯ НАМ ПОНАДОБЯТСЯ
        •	JsonReader – его можно использовать для чтения объекта JSON или массива JSON.
        •	Json – этот класс используется для создания объектов обработки JSON.
        •	JsonObject – аналогия JSON объекту
        •	JsonArray – аналогия JSON массиву
        •	JsonObjectBuilder – класс, который позволяет создать JsonObject с необходимыми связками «ключ-значение»
        •	JsonArrayBuilder – класс, который позволяет создать JsonArray, т.е. массив.
         */
        StringReader stringReader = new StringReader(jsonString);
        JsonReader jsonReader = Json.createReader(stringReader);

        JsonObject jsonObject = jsonReader.readObject();
        System.out.println(jsonObject);

        Human firstHuman = new Human(jsonObject);
        System.out.println(firstHuman);

        JsonObject humanJsonObject = firstHuman.toJson();
        System.out.println(humanJsonObject);

        Human secondHuman = new Human(humanJsonObject);
        System.out.println(secondHuman);
    }
}
