package llbean.projectocursoandroid_recetario.ui.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import llbean.projectocursoandroid_recetario.R;
import llbean.projectocursoandroid_recetario.bo.Recipe;
import llbean.projectocursoandroid_recetario.bo.User;
import llbean.projectocursoandroid_recetario.util.Constants;

/**
 * @author Mariano J
 */
public class EditRecipe extends BaseActivity {

    private static final String REQUIRED = "Requerido";
    private static final String TAG = "EditRecipe";

    private DatabaseReference mDatabase;
    private Button mSaveBtn;
    private EditText mTitleName;
    private EditText mSteps;
    private TextView mIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_recipe);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mSaveBtn = (Button) findViewById(R.id.save_btn);
        mTitleName = (EditText) findViewById(R.id.edit_recipe_name);
        mSteps = (EditText) findViewById(R.id.edit_recipe_steps);
        mIngredients = (TextView) findViewById(R.id.ingredient_list);
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
                Log.e(TAG, "Error getting the image: " + e.getMessage());
            }
        }
    }

    /**
     * Action to add new ingredients to the list
     * @param view
     */
    public void addIngredient(View view) {
        StringBuilder text = new StringBuilder();

        text.append(mIngredients.getText());
        text.append('\n');

        EditText ingredientQty = (EditText)findViewById(R.id.edit_ingredient_qty);
        text.append(ingredientQty.getText().toString());
        text.append(" ");

        Spinner measureSpinner = (Spinner)findViewById(R.id.measure_ddl);
        text.append(measureSpinner.getSelectedItem().toString());
        text.append(" de ");

        Spinner ingredientSpinner = (Spinner)findViewById(R.id.ingredient_ddl);
        text.append(ingredientSpinner.getSelectedItem().toString());

        mIngredients.setText(text.toString());
        ingredientQty.setText(""); // reset the quantity text
    }

    /**
     * Action to save the data
     * @param view
     */
    public void saveProduct(View view) {
        final String title = mTitleName.getText().toString();
        final String steps = mSteps.getText().toString();
        final String ingredients = mIngredients.getText().toString();
        final String image = getRecipeImageString();

        // Title is required
        if (TextUtils.isEmpty(title)) {
            mTitleName.setError(REQUIRED);
            return;
        }

        // Disable button so there are no multi-posts
        mSaveBtn.setEnabled(false);
        Toast.makeText(this, "Guardando...", Toast.LENGTH_SHORT).show();

        final String userId = getUid();
        mDatabase.child("users").child(userId).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        User user = dataSnapshot.getValue(User.class);

                        if (user == null) {
                            // User is null, error out
                            Log.e(TAG, "User " + userId + " is unexpectedly null");
                            Toast.makeText(EditRecipe.this, "Error: no se pudo conectar con el usuario.", Toast.LENGTH_SHORT).show();
                        } else {
                            // Save recipe
                            String key = mDatabase.child("recipes").push().getKey();
                            Recipe recipe = new Recipe(userId, title, image, steps, ingredients);
                            Map<String, Object> recipeMap = recipe.toMap();

                            Map<String, Object> childUpdates = new HashMap<>();
                            childUpdates.put("/recipes/" + key, recipeMap);
                            childUpdates.put("/user-recipes/" + userId + "/" + key, recipeMap);

                            mDatabase.updateChildren(childUpdates);
                        }

                        // Finish this Activity, back to the stream
                        mSaveBtn.setEnabled(true);
                        finish();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                        mSaveBtn.setEnabled(true);
                    }
                });
    }

    private String getRecipeImageString() {
        String imgString;

        ImageView imgView = (ImageView) findViewById(R.id.recipe_img_view);
        Bitmap bitmap = ((BitmapDrawable)imgView.getDrawable()).getBitmap();

        if (bitmap == null) {
            imgString = "";
        } else {
            ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutput);
            bitmap.recycle();
            byte[] byteArray = byteArrayOutput.toByteArray();
            imgString = Base64.encodeToString(byteArray, Base64.DEFAULT);
        }

        return imgString;
    }

}
