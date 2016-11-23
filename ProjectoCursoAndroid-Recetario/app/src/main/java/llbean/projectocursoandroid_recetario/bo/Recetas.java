package llbean.projectocursoandroid_recetario.bo;

import llbean.projectocursoandroid_recetario.R;

/**
 * Created by ydesanti on 11/22/2016.
 */

public class Recetas {
    private String name;

    public Recetas(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChevron() {
        return R.drawable.ic_go_to_details_chevron;
    }
}
