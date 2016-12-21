package llbean.projectocursoandroid_recetario.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import llbean.projectocursoandroid_recetario.R;
import llbean.projectocursoandroid_recetario.ui.adapters.DividerDecorator;
import llbean.projectocursoandroid_recetario.ui.adapters.RecyclerViewAdapter;
import llbean.projectocursoandroid_recetario.util.CargarListaRecetas;
import llbean.projectocursoandroid_recetario.viewModel.SearchViewModel;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new SearchViewModel(getApplicationContext(), (RecyclerView) findViewById(R.id.listRecetas)).searchRecipes();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }
}
