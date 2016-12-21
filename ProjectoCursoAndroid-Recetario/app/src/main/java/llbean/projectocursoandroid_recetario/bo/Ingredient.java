package llbean.projectocursoandroid_recetario.bo;

import java.util.HashMap;
import java.util.Map;

public class Ingredient {
    private String userId;
    private String name;

    public Ingredient(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap();
        map.put("userId", userId);
        map.put("name", name);
        return map;
    }

}
