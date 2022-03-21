import javax.json.*;
import java.util.Arrays;

public class Human {
    private String name;
    private int age;
    private boolean isMarried;
    private Child[] children;
    private String[] skills;

    public Human(JsonObject jsonObject) {
        name = jsonObject.getString("name");
        age = jsonObject.getInt("age");
        isMarried = jsonObject.getBoolean("is_married");

        JsonArray childrenArray = jsonObject.getJsonArray("children");
        children = new Child[childrenArray.size()];
        for (int i = 0; i < children.length; i++) {
            JsonObject jsonChild = childrenArray.getJsonObject(i);
            Child child = new Child(jsonChild);
            children[i] = child;
        }

        JsonArray jsonSkills = jsonObject.getJsonArray("skills");
        skills = new String[jsonSkills.size()];
        for (int i = 0; i < skills.length; i++) {
            skills[i] = jsonSkills.getJsonString(i).getString();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("name: " + name + "\n");
        sb.append("age: " + age + "\n");
        sb.append("is Married: " + isMarried + "\n");
        sb.append("children: " + Arrays.toString(children) + "\n");
        sb.append("skills: " + Arrays.toString(skills) + "\n");

        return sb.toString();
    }

    public JsonObject toJson() {
        JsonObjectBuilder humanJsonObjectBuilder = Json.createObjectBuilder();
        humanJsonObjectBuilder = humanJsonObjectBuilder
            .add("name", name)
            .add("age", age)
            .add("is_married", isMarried);

        JsonArrayBuilder childrenArrayBuilder = Json.createArrayBuilder();
        for (Child child : children) {
            childrenArrayBuilder.add(child.toJson());
        }

        humanJsonObjectBuilder.add("children", childrenArrayBuilder.build());

        JsonArrayBuilder skillsArrayBuilder = Json.createArrayBuilder();
        for (String skill : skills) {
            skillsArrayBuilder.add(skill);
        }

        humanJsonObjectBuilder.add("skills", skillsArrayBuilder.build());

        return humanJsonObjectBuilder.build();
    }
}
