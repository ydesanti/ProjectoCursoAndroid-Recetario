package llbean.projectocursoandroid_recetario.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import llbean.projectocursoandroid_recetario.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }
}
