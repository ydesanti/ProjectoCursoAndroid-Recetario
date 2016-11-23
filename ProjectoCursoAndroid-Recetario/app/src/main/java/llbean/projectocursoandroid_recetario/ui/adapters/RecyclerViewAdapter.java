package llbean.projectocursoandroid_recetario.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import llbean.projectocursoandroid_recetario.R;
import llbean.projectocursoandroid_recetario.bo.Recetas;
import llbean.projectocursoandroid_recetario.util.CustomLayoutForRecipiesRow;

/**
 * Created by ydesanti on 11/22/2016.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderClass> {

    private List<Recetas> mListaRecetas;
    public RecyclerViewAdapter(List<Recetas> recetas) {
        this.mListaRecetas = recetas;
    }

    @Override
    public ViewHolderClass onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_view, parent, false);
       return new ViewHolderClass(v);
    }

    @Override
    public void onBindViewHolder(ViewHolderClass holder, int position) {
        Recetas receta = mListaRecetas.get(position);
        holder.mListaRecetas.setProductInfo(receta);
        holder.chevrom.setImageResource(receta.getChevron());
    }

    @Override
    public int getItemCount() {
        return mListaRecetas.size();
    }

    class ViewHolderClass extends RecyclerView.ViewHolder {

        CustomLayoutForRecipiesRow mListaRecetas;
        ImageView chevrom;

        public ViewHolderClass(View itemView) {
            super(itemView);

            mListaRecetas = (CustomLayoutForRecipiesRow) itemView.findViewById(R.id.customRowView);
            chevrom = (ImageView) itemView.findViewById(R.id.detailsChevron);
        }
    }

}