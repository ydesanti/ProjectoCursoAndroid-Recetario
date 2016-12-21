package llbean.projectocursoandroid_recetario.api;

import llbean.projectocursoandroid_recetario.models.RecipeFeed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ydesanti on 12/3/2016.
 */

public interface ApiInterface {
    @GET("api/search?key=c5384cd76b3e2f2b065990d27bd62bd2")
    Call<RecipeFeed> getRecipies(@Query("q") String query, @Query("page") int page);

    @GET("api/search?key=c5384cd76b3e2f2b065990d27bd62bd2")
    Call<RecipeFeed> getAllRecipies();

    @GET("api/get?key=c5384cd76b3e2f2b065990d27bd62bd2")
    Call<RecipeFeed> getDetails();
}
