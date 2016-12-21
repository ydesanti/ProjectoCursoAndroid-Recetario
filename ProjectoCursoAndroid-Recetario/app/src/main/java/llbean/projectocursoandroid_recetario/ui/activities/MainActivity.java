package llbean.projectocursoandroid_recetario.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import llbean.projectocursoandroid_recetario.R;
import llbean.projectocursoandroid_recetario.bo.Recipe;
import llbean.projectocursoandroid_recetario.ui.adapters.DividerDecorator;
import llbean.projectocursoandroid_recetario.ui.adapters.RecyclerViewAdapter;
import llbean.projectocursoandroid_recetario.util.Constants;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadRecipes();
    }

    /**
     * Carga la lista de recetas en el recycler view
     */
    private void loadRecipes() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.load_repipe_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        int dividerHeight = getResources().getDimensionPixelSize(R.dimen.divider);
        DividerDecorator dividerDecorator = new DividerDecorator(dividerHeight);
        recyclerView.addItemDecoration(dividerDecorator);

        final List<Recipe> list = new ArrayList<>();

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child(Constants.RECIPES).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {

                    String title = snapshot.child("title").getValue(String.class);
                    String steps = snapshot.child("steps").getValue(String.class);
                    String ingredients = snapshot.child("ingredients").getValue(String.class);
                    String image = snapshot.child("image").getValue(String.class);

                    Recipe recipe = new Recipe(getUid(), title, image, steps, ingredients);
                    list.add(recipe);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadIngredientsDDL:onCancelled", databaseError.toException());
            }
        });

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void refresh(View view) {
        loadRecipes();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }
}
