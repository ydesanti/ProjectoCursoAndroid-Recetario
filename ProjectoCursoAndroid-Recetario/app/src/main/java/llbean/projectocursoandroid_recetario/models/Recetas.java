package llbean.projectocursoandroid_recetario.models;

import com.google.gson.annotations.SerializedName;

import llbean.projectocursoandroid_recetario.R;

/**
 * Created by ydesanti on 11/22/2016.
 */

public class Recetas {
    @SerializedName("Title")
    private String mTitle;

    @SerializedName("Id")
    private String mId;

    @SerializedName("Image")
    private String mImageURL;

    @SerializedName("Ingredients")
    private String mIngredients;

    @SerializedName("Rank")
    private String mSocialRank;

    @SerializedName("Source")
    private String mSourceURL;


    public Recetas(String mTitle, String mId, String mImageURL, String mIngredients, String mSocialRank, String mSourceURL) {
        setTitle(mTitle);
        setmId(mId);
        setmImageURL(mImageURL);
        setmIngredients(mIngredients);
        setmSocialRank(mSocialRank);
        setmSourceURL(mSourceURL);
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmImageURL() {
        return mImageURL;
    }

    public void setmImageURL(String mImageURL) {
        this.mImageURL = mImageURL;
    }

    public String getmIngredients() {
        return mIngredients;
    }

    public void setmIngredients(String mIngredients) {
        this.mIngredients = mIngredients;
    }

    public String getmSocialRank() {
        return mSocialRank;
    }

    public void setmSocialRank(String mSocialRank) {
        this.mSocialRank = mSocialRank;
    }

    public String getmSourceURL() {
        return mSourceURL;
    }

    public void setmSourceURL(String mSourceURL) {
        this.mSourceURL = mSourceURL;
    }

    public int getChevron() {
        return R.drawable.ic_go_to_details_chevron;
    }
}
