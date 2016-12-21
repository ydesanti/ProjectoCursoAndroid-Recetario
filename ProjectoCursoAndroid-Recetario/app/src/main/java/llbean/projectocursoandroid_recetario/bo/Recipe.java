package llbean.projectocursoandroid_recetario.bo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

public class Recipe implements Parcelable {
    private String userId;
    private String title;
    private String image;
    private String steps;
    private String ingredients;

    public Recipe(String userId, String title, String image, String steps, String ingredients) {
        this.userId = userId;
        this.title = title;
        this.image = image;
        this.steps = steps;
        this.ingredients = ingredients;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap();
        map.put("userId", userId);
        map.put("title", title);
        map.put("steps", steps);
        map.put("ingredients", ingredients);
        map.put("image", image);
        return map;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
        dest.writeString(this.title);
        dest.writeString(this.image);
        dest.writeString(this.steps);
        dest.writeString(this.ingredients);
    }

    protected Recipe(Parcel in) {
        this.userId = in.readString();
        this.title = in.readString();
        this.image = in.readString();
        this.steps = in.readString();
        this.ingredients = in.readString();
    }

    public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel source) {
            return new Recipe(source);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
}
