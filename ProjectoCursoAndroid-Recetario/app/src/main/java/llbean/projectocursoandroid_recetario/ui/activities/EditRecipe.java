package llbean.projectocursoandroid_recetario.ui.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;

import llbean.projectocursoandroid_recetario.R;
import llbean.projectocursoandroid_recetario.util.Constants;

/**
 * @author Mariano J
 */
public class EditRecipe extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_recipe);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_edit_recipe;
    }

    /**
     * Action to load the image in the form
     * @param view
     */
    public void loadImage(View view) {
        Intent intent = new Intent();
        // Show only images, no videos or anything else
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        // Always show the chooser (if there are multiple options available)
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), Constants.PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // get the selected image in the ImageView
        if (requestCode == Constants.PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                ImageView imageView = (ImageView) findViewById(R.id.recipe_img_view);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Action to add new ingredients to the list
     * @param view
     */
    public void addIngredient(View view) {
        StringBuilder text = new StringBuilder();

        EditText ingredientQty = (EditText)findViewById(R.id.edit_ingredient_qty);
        text.append(ingredientQty.getText().toString());
        text.append(" ");

        Spinner measureSpinner = (Spinner)findViewById(R.id.measure_ddl);
        text.append(measureSpinner.getSelectedItem().toString());
        text.append(" de ");

        Spinner ingredientSpinner = (Spinner)findViewById(R.id.ingredient_ddl);
        text.append(ingredientSpinner.getSelectedItem().toString());

        TextView newIngredient = new TextView(this);
        newIngredient.setText(text.toString());

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.ingredient_list_layout);
        linearLayout.addView(newIngredient);
    }

    /**
     * Action to save the data
     * @param view
     */
    public void saveProduct(View view) {
        //TODO
    }

}
