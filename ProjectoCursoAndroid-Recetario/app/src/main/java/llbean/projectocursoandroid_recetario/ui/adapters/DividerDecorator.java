package llbean.projectocursoandroid_recetario.ui.adapters;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by ydesanti on 11/22/2016.
 */

public class DividerDecorator extends RecyclerView.ItemDecoration {

    private final int verticalSpaceHeight;

    public DividerDecorator(int verticalSpaceHeight) {
        this.verticalSpaceHeight = verticalSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.bottom = verticalSpaceHeight;
    }
}
