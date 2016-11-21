package llbean.projectocursoandroid_recetario.ui.activities;

/**
 * Created by ydesanti on 11/20/2016.
 */

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_recetas:
                // TODO
                break;
            case R.id.menu_ingredientes:
                // TODO
                break;
            case R.id.menu_recordatorios:
                //TODO
                break;
            case R.id.menu_buscar:
                //TODO
                break;

        }
        return true;
    }


    @LayoutRes
    protected abstract int getLayoutResource();
}

