package llbean.projectocursoandroid_recetario.ui.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import llbean.projectocursoandroid_recetario.R;
import llbean.projectocursoandroid_recetario.bo.Ingredient;
import llbean.projectocursoandroid_recetario.bo.User;
import llbean.projectocursoandroid_recetario.util.Constants;

public class EditIngredient extends BaseActivity {

    private static final String TAG = "EditIngredient";
    private DatabaseReference mDatabase;
    private Button mSaveBtn;
    private EditText mIngredientName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ingredient);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mSaveBtn = (Button) findViewById(R.id.save_ingredient_btn);
        mIngredientName = (EditText) findViewById(R.id.edit_ingredient_name);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_edit_ingredient;
    }

    /**
     * Action to save the ingredient
     * @param view The view that was clicked
     */
    public void saveIngredient(View view) {
        final String name = mIngredientName.getText().toString();

        // Title is required
        if (TextUtils.isEmpty(name)) {
            mIngredientName.setError(Constants.REQUIRED);
            return;
        }

        // Disable button so there are no multi-posts
        mSaveBtn.setEnabled(false);
        Toast.makeText(this, Constants.SAVING, Toast.LENGTH_SHORT).show();

        final String userId = getUid();
        mDatabase.child(Constants.USERS).child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get user value
                User user = dataSnapshot.getValue(User.class);

                if (user == null) {
                    // User is null, error out
                    Log.e(TAG, "User " + userId + " is unexpectedly null");
                    Toast.makeText(EditIngredient.this, Constants.ERROR_USER, Toast.LENGTH_SHORT).show();
                } else {
                    // Save ingredient
                    String key = mDatabase.child(Constants.INGREDIENTS).push().getKey();
                    Ingredient ingredient = new Ingredient(userId, name);
                    Map<String, Object> map = ingredient.toMap();

                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put("/ingredients/" + key, map);
                    childUpdates.put("/user-ingredients/" + userId + "/" + key, map);

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
}
