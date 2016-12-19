package llbean.projectocursoandroid_recetario.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import llbean.projectocursoandroid_recetario.BR;
import llbean.projectocursoandroid_recetario.models.RecipeFeed;
import llbean.projectocursoandroid_recetario.ui.adapters.RecyclerViewAdapter;
import llbean.projectocursoandroid_recetario.util.MyApplication;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by ydesanti on 12/11/2016.
 */

public class SearchViewModel extends BaseObservable {
    private String mQuery;

    private RecyclerViewAdapter mAdapter;

    private int mTotalPages;

    private int mCurrentPage;

    private boolean mIsLoading;

    private String mSearchCriteria;


    public SearchViewModel(Context context, RecyclerView recyclerView) {
        mAdapter = new RecyclerViewAdapter(context);
        recyclerView.setAdapter(mAdapter);
        mCurrentPage = 1;
    }


    public View.OnClickListener searchRecipesClickListener() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                searchRecipes();
            }
        };
    }

    @Bindable
    public String getQuery() {
        return mQuery;
    }


    public void setQuery(String query) {
        mQuery = query;
        notifyPropertyChanged(BR.search);

    }

    private void searchRecipes() {
        mSearchCriteria = getQuery();
        mAdapter.reset();
        requestRecipes();
    }


    private void requestRecipes() {
        Call<RecipeFeed> call = MyApplication.getInstance().getAPISeach().getImages(mSearchCriteria, mCurrentPage);
        Log.d(TAG, call.request().toString());
        call.enqueue(new Callback<RecipeFeed>() {
            @Override
            public void onResponse(Call<RecipeFeed> call, Response<RecipeFeed> response) {
                Log.d(TAG, "success");
                mIsLoading = false;
                if (response.body().getRecetas() != null) {
                    mAdapter.addRecipies(response.body().getRecetas());
                    mTotalPages = response.body().getTotalResults();
                }
            }

            @Override
            public void onFailure(Call<RecipeFeed> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }


    public RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

            int total = layoutManager.getItemCount();
            int lastVisibleItemCount = layoutManager.findLastVisibleItemPosition();

            if (!mIsLoading) {
                if (total > 0)
                    if ((total - 1) == lastVisibleItemCount) {
                        if (mCurrentPage < mTotalPages) {
                            mCurrentPage++;
                            mIsLoading = true;
                            requestRecipes();
                        }
                    }
            }
        }
    };
}
