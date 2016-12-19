package llbean.projectocursoandroid_recetario.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ydesanti on 12/11/2016.
 */

public class RecipeFeed {
    @SerializedName("Search")
    private List<Recetas> mRecetas;

    @SerializedName("TotalResults")
    private int mTotalResults;

    public List<Recetas> getRecetas() {
        return mRecetas;
    }

    public void setRecetas(List<Recetas> movies) {
        mRecetas = movies;
    }

    public int getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(int totalResults) {
        mTotalResults = totalResults;
    }
}
