package llbean.projectocursoandroid_recetario.viewModel;

import android.databinding.BaseObservable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import llbean.projectocursoandroid_recetario.R;

/**
 * Created by ydesanti on 12/11/2016.
 */

public class MenuViewModel extends BaseObservable {

    private Boolean visible = false;
    private LinearLayout searchSection;

    public View.OnClickListener searchRecipesClickListener() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                enableSearch();
            }
        };
    }

    public void enableSearch() {
        //searchSection = (LinearLayout) findViewById(R.id.searchSection);
    }
}
