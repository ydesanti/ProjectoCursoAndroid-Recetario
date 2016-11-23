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

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listRecetas);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(CargarListaRecetas.crearListaRecetas());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        int dividerHeight = getResources().getDimensionPixelSize(R.dimen.divider);
        DividerDecorator dividerDecorator = new DividerDecorator(dividerHeight);
        recyclerView.addItemDecoration(dividerDecorator);

        recyclerView.setAdapter(adapter);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }
}
