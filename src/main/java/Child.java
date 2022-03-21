import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class Child {
    private String name;
    private int age;

    public Child(JsonObject jsonObject) {
        name = jsonObject.getString("name");
        age = jsonObject.getInt("age");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("name: " + name);
        sb.append(" age: " + age);

        return sb.toString();
    }

    public JsonObject toJson() {
        JsonObjectBuilder childObjectBuilder = Json.createObjectBuilder();
        childObjectBuilder = childObjectBuilder.add("name", name).add("age", age);
        return childObjectBuilder.build();
    }
}
