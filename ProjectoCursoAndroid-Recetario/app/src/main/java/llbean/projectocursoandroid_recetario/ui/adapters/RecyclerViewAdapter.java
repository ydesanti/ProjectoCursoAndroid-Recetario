package llbean.projectocursoandroid_recetario.ui.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import llbean.projectocursoandroid_recetario.R;
import llbean.projectocursoandroid_recetario.bo.Recipe;
import llbean.projectocursoandroid_recetario.ui.activities.RecipyDetails;
import llbean.projectocursoandroid_recetario.util.CustomLayoutForRecipiesRow;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecipeHolderClass> {

    private List<Recipe> mRecipeList;

    public RecyclerViewAdapter(List<Recipe> list) {
        this.mRecipeList = list;
    }

    @Override
    public RecipeHolderClass onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_view, parent, false);
        return new RecipeHolderClass(view);
    }

    @Override
    public void onBindViewHolder(RecipeHolderClass holder, int position) {
        Recipe recipe = mRecipeList.get(position);

        holder.mRecipeRow.setRecipeInfo(recipe);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    class RecipeHolderClass extends RecyclerView.ViewHolder implements View.OnClickListener {

        CustomLayoutForRecipiesRow mRecipeRow;
        ImageView chevrom;

        RecipeHolderClass(View itemView) {
            super(itemView);

            mRecipeRow = (CustomLayoutForRecipiesRow) itemView.findViewById(R.id.customRowView);
            chevrom = (ImageView) itemView.findViewById(R.id.detailsChevron);
            chevrom.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent details = new Intent(view.getContext(), RecipyDetails.class);
            details.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            view.getContext().getApplicationContext().startActivity(details);
        }
    }

}
