package llbean.projectocursoandroid_recetario.ui.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import llbean.projectocursoandroid_recetario.R;
import llbean.projectocursoandroid_recetario.databinding.CustomRowViewBinding;
import llbean.projectocursoandroid_recetario.models.Recetas;
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
       CustomRowViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.custom_row_view, parent, false);

        return new ViewHolderClass(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolderClass holder, int position) {
        Recetas receta = mListaRecetas.get(position);

        CustomRowViewBinding binding = holder.mBinding;
        binding.setRecipe(new RecipeViewModel(mContext, receta));
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
    }

}
