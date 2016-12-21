package llbean.projectocursoandroid_recetario.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import llbean.projectocursoandroid_recetario.R;
import llbean.projectocursoandroid_recetario.models.Recetas;

/**
 * Created by ydesanti on 12/11/2016.
 */

public class RecipeViewModel extends BaseObservable {
    private Context mContext;

    private Recetas mRecetas;


    public RecipeViewModel(Context context, Recetas mRecetas) {
        mContext = context;
        mRecetas = mRecetas;
    }

    @Bindable
    public String getTitle() {
        return mContext.getString(R.string.recipe_name, mRecetas.getTitle());
    }

    public void setTitle(String title) {
        mRecetas.setTitle(title);
        notifyChange();
    }

    @Bindable
    public String getId() {
        return mContext.getString(R.string.recipe_id, mRecetas.getmId());
    }

    public void setId(String id) {
        mRecetas.setmId(id);
        notifyChange();
    }

    @Bindable
    public String getImage() {
        return mRecetas.getmImageURL();
    }

    public void setImage(String image) {
        mRecetas.setmImageURL(image);
        notifyChange();
    }

    @BindingAdapter("app:imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Picasso.with(imageView.getContext()).load(url)
                .resizeDimen(R.dimen.image_width, R.dimen.image_height)
                .into(imageView);
    }

    @Bindable
    public String getIngredients() {
        return mRecetas.getmIngredients();
    }

    public void setIngredients(String ingredients) {
        mRecetas.setmIngredients(ingredients);
        notifyChange();
    }

    @Bindable
    public String getRank() {
        return mRecetas.getmSocialRank();
    }

    public void setRank(String rank) {
        mRecetas.setmSocialRank(rank);
        notifyChange();
    }
}
