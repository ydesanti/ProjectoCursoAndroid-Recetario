package llbean.projectocursoandroid_recetario.api;

import llbean.projectocursoandroid_recetario.util.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ydesanti on 12/3/2016.
 */

public class ApiClient {
    private static Retrofit sRetrofit;

    public static Retrofit getSearchInstance() {

        if (sRetrofit == null) {

            sRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
