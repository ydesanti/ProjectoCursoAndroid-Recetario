package llbean.projectocursoandroid_recetario.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import llbean.projectocursoandroid_recetario.R;
import llbean.projectocursoandroid_recetario.bo.Recipe;

public class CustomLayoutForRecipiesRow extends LinearLayout {
    public CustomLayoutForRecipiesRow(Context context) {
        super(context);
        init(context);
    }

    public CustomLayoutForRecipiesRow(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomLayoutForRecipiesRow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        setBackgroundResource(R.drawable.recipesrowbackground);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.default_recipe_row, this, true);
    }

    public void setRecipeInfo(Recipe recipe) {
        TextView mRecipeName = (TextView) findViewById(R.id.recipeName);

        mRecipeName.setText(recipe.getTitle());
    }
}
