package guru.springframework.recipe.service;

import guru.springframework.recipe.command.RecipeCommand;
import guru.springframework.recipe.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand findRecipeCommandById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(long idToDelete);
}
