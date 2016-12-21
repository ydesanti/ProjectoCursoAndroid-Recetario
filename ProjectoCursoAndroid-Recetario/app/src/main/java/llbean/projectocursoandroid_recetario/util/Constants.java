package llbean.projectocursoandroid_recetario.util;

public interface Constants {

    //API URL
    String ENDPOINT = "http://food2fork.com/api/";

    // ACTIVITIES REQUESTS
    int PICK_IMAGE_REQUEST = 1;

    // DATABASE TABLES
    String USERS = "users";
    String RECIPES = "recipes";
    String INGREDIENTS = "ingredients";
    String USER_INGREDIENTS = "user-ingredients";

    // MESSAGES
    String REQUIRED = "Campo Requerido";
    String SAVING = "Guardando...";
    String ERROR_USER = "Error: no se pudo conectar con el usuario.";
}
