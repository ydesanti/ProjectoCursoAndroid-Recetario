package llbean.projectocursoandroid_recetario.ui.activities;

/**
 * Created by ydesanti on 11/20/2016.
 */

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import llbean.projectocursoandroid_recetario.R;


public abstract class BaseActivity extends AppCompatActivity {


    protected Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    @LayoutRes
    protected abstract int getLayoutResource();
}

