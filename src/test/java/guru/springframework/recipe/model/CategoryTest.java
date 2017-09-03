package guru.springframework.recipe.model;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    private Category category;

    @Before
    public void setUp() throws Exception {
        category = new Category();
    }

    @Test
    public void getId() throws Exception {
        Long idValue = 3L;

        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    public void getCategoryName() throws Exception {
        String categoryName = "Fast Food";

        category.setCategoryName(categoryName);

        assertEquals(categoryName, category.getCategoryName());
    }

    @Test
    public void getRecipes() throws Exception {
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);
        recipes.add(recipe1);
        recipes.add(recipe2);

        category.setRecipes(recipes);

        assertEquals(2, category.getRecipes().size());
    }

}