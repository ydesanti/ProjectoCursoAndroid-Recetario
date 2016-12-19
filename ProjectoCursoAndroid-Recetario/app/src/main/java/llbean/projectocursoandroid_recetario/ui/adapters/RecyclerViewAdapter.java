package llbean.projectocursoandroid_recetario.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import llbean.projectocursoandroid_recetario.R;
import llbean.projectocursoandroid_recetario.databinding.CustomRowViewBinding;
import llbean.projectocursoandroid_recetario.models.Recetas;
import llbean.projectocursoandroid_recetario.ui.activities.RecipyDetails;
import llbean.projectocursoandroid_recetario.util.CustomLayoutForRecipiesRow;
import llbean.projectocursoandroid_recetario.viewModel.RecipeViewModel;

/**
 * Created by ydesanti on 11/22/2016.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderClass> {

    private Context mContext;
    private List<Recetas> mListaRecetas;

    public RecyclerViewAdapter (Context context) {
        mContext = context;
        mListaRecetas = new ArrayList<>();
    }

    public RecyclerViewAdapter(List<Recetas> recetas) {
        this.mListaRecetas = recetas;
    }

    public void setRecipies(List<Recetas> movies) {
        mListaRecetas = movies;
        notifyDataSetChanged();
    }

    public void addRecipies(List<Recetas> recetas) {
        mListaRecetas.addAll(recetas);
        notifyDataSetChanged();
    }

    public void reset() {
        mListaRecetas.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolderClass onCreateViewHolder(ViewGroup parent, int viewType) {
      /* View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_view, parent, false);
       return new ViewHolderClass(v);*/

        CustomRowViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.custom_row_view, parent, false);

        return new ViewHolderClass(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolderClass holder, int position) {
        Recetas receta = mListaRecetas.get(position);

        CustomRowViewBinding binding = holder.mBinding;
        binding.setRecipe(new RecipeViewModel(mContext, receta));

        /*holder.mListaRecetas.setProductInfo(receta);
        holder.chevrom.setImageResource(receta.getChevron());*/
    }

    @Override
    public int getItemCount() {
        return mListaRecetas.size();
    }

    /**
     * ViewHolderClass
     */
    public class ViewHolderClass extends RecyclerView.ViewHolder{

        CustomRowViewBinding mBinding;

        public ViewHolderClass(CustomRowViewBinding binding) {
            super(binding.customRowView);
            mBinding = binding;
        }

        /*CustomLayoutForRecipiesRow mListaRecetas;
        ImageView chevrom;

        public ViewHolderClass(View itemView) {
            super(itemView);

            mListaRecetas = (CustomLayoutForRecipiesRow) itemView.findViewById(R.id.customRowView);
            chevrom = (ImageView) itemView.findViewById(R.id.detailsChevron);
            chevrom.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
            Intent details = new Intent(view.getContext(), RecipyDetails.class);
            details.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            view.getContext().getApplicationContext().startActivity(details);
        }*/
    }

}
