package llbean.projectocursoandroid_recetario.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import llbean.projectocursoandroid_recetario.R;

public class RecipyDetails extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, RecipyDetails.class);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_recipy_details;
    }

}
