package llbean.projectocursoandroid_recetario.util;

import android.app.Application;

import llbean.projectocursoandroid_recetario.api.ApiClient;
import llbean.projectocursoandroid_recetario.api.ApiInterface;

/**
 * Created by ydesanti on 12/11/2016.
 */

public class MyApplication extends Application {

    private static MyApplication sInstance;
    private ApiInterface mApiSearchInterface;
    private ApiInterface mApiDetailsInterface;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mApiSearchInterface = ApiClient.getSearchInstance().create(ApiInterface.class);
    }

    public MyApplication() {
        if (sInstance == null) {
            sInstance = this;
            mApiSearchInterface = ApiClient.getSearchInstance().create(ApiInterface.class);
        }
    }

    public ApiInterface getAPISeach() {
        return mApiSearchInterface;
    }

    public static MyApplication getInstance() {
        return sInstance;
    }
}