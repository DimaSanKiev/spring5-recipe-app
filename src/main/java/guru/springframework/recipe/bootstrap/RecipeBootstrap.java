package guru.springframework.recipe.bootstrap;

import guru.springframework.recipe.model.*;
import guru.springframework.recipe.repostitory.CategoryRepository;
import guru.springframework.recipe.repostitory.RecipeRepository;
import guru.springframework.recipe.repostitory.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>(2);

        // Get units of measure
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
        if (!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if (!tableSpoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if (!teaSpoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
        if (!dashUomOptional.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");
        if (!pinchUomOptional.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
        if (!cupUomOptional.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");
        if (!ounceUomOptional.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<UnitOfMeasure> gramsUomOptional = unitOfMeasureRepository.findByDescription("Grams");
        if (!gramsUomOptional.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
        if (!pintUomOptional.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<UnitOfMeasure> poundUomOptional = unitOfMeasureRepository.findByDescription("Pound");
        if (!poundUomOptional.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        // Get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pinchUom = pinchUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();
        UnitOfMeasure gramsUom = gramsUomOptional.get();
        UnitOfMeasure ounceUom = ounceUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure poundUom = poundUomOptional.get();

        // Get categories
        Optional<Category> ukrainianCategoryOptional = categoryRepository.findByCategoryName("Ukrainian");
        if (!ukrainianCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> scandinavianCategoryOptional = categoryRepository.findByCategoryName("Scandinavian");
        if (!scandinavianCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> americanCategoryOptional = categoryRepository.findByCategoryName("American");
        if (!americanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> frenchCategoryOptional = categoryRepository.findByCategoryName("French");
        if (!frenchCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> australianCategoryOptional = categoryRepository.findByCategoryName("Australian");
        if (!australianCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> italianCategoryOptional = categoryRepository.findByCategoryName("Italian");
        if (!italianCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByCategoryName("Mexican");
        if (!mexicanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> fastFoodCategoryOptional = categoryRepository.findByCategoryName("Fast Food");
        if (!fastFoodCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Category ukrainianCategory = ukrainianCategoryOptional.get();
        Category scandinavianCategory = scandinavianCategoryOptional.get();
        Category americanCategory = americanCategoryOptional.get();
        Category frenchCategory = frenchCategoryOptional.get();
        Category australianCategory = australianCategoryOptional.get();
        Category italianCategory = italianCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();
        Category fastFoodCategory = fastFoodCategoryOptional.get();

        // Chilled Cucumber Soup, http://www.simplyrecipes.com/recipes/cucumber_soup/
        Recipe chillySoupRecipe = new Recipe();
        chillySoupRecipe.setDescription("Cool and refreshing Chilled Cucumber Soup! Takes only 10 minutes to make, no cooking, just blending.");
        chillySoupRecipe.setPrepTime(10);
        chillySoupRecipe.setCookTime(0);
        chillySoupRecipe.setDifficulty(Difficulty.EASY);
        chillySoupRecipe.setDirections("1 Prep: Peel, seed, and roughly chop the cucumbers. Chop the onion and dill.\n" +
                "2 Blend: Put all of the ingredients into a blender and pulse until completely smooth. Adjust seasonings to taste. Add more salt and pepper if needed.\n" +
                "At this point you can make ahead and chill.\n" +
                "3 Serve: Pour into bowls and garnish with a drizzle of olive oil and a feather of dill.\n");

        Notes chillyCucumberSoupNotes = new Notes();
        chillyCucumberSoupNotes.setRecipeNotes("This cucumber soup is incredibly easy to make, taking no more than 10 minutes. All you have to do is peel and seed the cucumbers, and pulse them in a blender with a little chopped onion, buttermilk, sour cream, olive oil, dill, salt and pepper.\n" +
                "If you don’t have buttermilk or sour cream, you can sub with plain yogurt.\n" +
                "It’s a chilled soup that you can make ahead and eat for days. Perfect for hot summer days.\n" +
                "Many thanks to my friend Sue Robison who gave me the bones of this recipe to play with. Enjoy!\n" +
                "Read more: http://www.simplyrecipes.com/recipes/cucumber_soup/#ixzz4rWHbFoOB");

        chillyCucumberSoupNotes.setRecipe(chillySoupRecipe);
        chillySoupRecipe.setNotes(chillyCucumberSoupNotes);

        // Add ingredients
        chillySoupRecipe.getIngredients().add(new Ingredient("large cucumbers", new BigDecimal(2), eachUom, chillySoupRecipe));
        chillySoupRecipe.getIngredients().add(new Ingredient("chopped onion (white, red, or green)", new BigDecimal(2), tableSpoonUom, chillySoupRecipe));
        chillySoupRecipe.getIngredients().add(new Ingredient("buttermilk", new BigDecimal(0.5), cupUom, chillySoupRecipe));
        chillySoupRecipe.getIngredients().add(new Ingredient("sour cream", new BigDecimal(0.25), cupUom, chillySoupRecipe));
        chillySoupRecipe.getIngredients().add(new Ingredient("rice vinegar", new BigDecimal(1), tableSpoonUom, chillySoupRecipe));
        chillySoupRecipe.getIngredients().add(new Ingredient("olive oil", new BigDecimal(1), tableSpoonUom, chillySoupRecipe));
        chillySoupRecipe.getIngredients().add(new Ingredient("fresh dill, chopped", new BigDecimal(2), tableSpoonUom, chillySoupRecipe));
        chillySoupRecipe.getIngredients().add(new Ingredient("salt", new BigDecimal(1), teaSpoonUom, chillySoupRecipe));
        chillySoupRecipe.getIngredients().add(new Ingredient("black pepper", new BigDecimal(1), pinchUom, chillySoupRecipe));

        // Add categories
        chillySoupRecipe.getCategories().add(italianCategory);
        chillySoupRecipe.getCategories().add(scandinavianCategory);

        // Add to return list
        recipes.add(chillySoupRecipe);

        // Grilled Shrimp Tacos, http://www.simplyrecipes.com/recipes/grilled_shrimp_tacos_with_mango_avocado_salsa/
        Recipe shrimpTacosRecipe = new Recipe();
        shrimpTacosRecipe.setDescription("Grilled shrimp tacos with a salsa of fresh mango, avocado, red onion, jalapeño, and lime juice.");
        shrimpTacosRecipe.setPrepTime(25);
        shrimpTacosRecipe.setCookTime(20);
        shrimpTacosRecipe.setDifficulty(Difficulty.KIND_OF_HARD);
        shrimpTacosRecipe.setDirections("1 Defrost frozen shrimp: If you are starting with frozen shrimp, put a quart of cold water in a large bowl and add a tablespoon of salt. Stir until the salt is dissolved. Add the shrimp and several large ice cubes. Let sit until defrosted (keep ice in the water).\n" +
                "If your shrimp is fresh or already defrosted, if you want you can put the shrimp in salty water for 15 minutes or until you are ready to thread skewers and grill the shrimp.\n" +
                "2 Prepare the salsa: Place the chopped mango, avocado, red onion, jalapeño in a bowl. Sprinkle with salt and gently toss with fresh lime or lemon juice. Add fresh cilantro (if using) right before serving.\n" +
                "3 Prepare your grill for high direct heat (you'll know it's hot enough when you can hold your hand 1 inch above the grill grates for 1 second).\n" +
                "4 Thread the shrimp onto skewers: Use two bamboo skewers at a time to thread the shrimp.  This will make it easier to turn and keep the shrimp from spinning on the skewer." +
                "Starting at the big end of the shrimp, hold the shrimp in a tight spiral like the shape of an apostrophe. Starting at the large end of the shrimp, thread the 2 skewers through the shrimp, starting at the big end and going through the smaller end, right before the tail section.\n" +
                "Thread 3 to 4 or more on a skewer, depending on how long your skewers are, leaving a little space between each shrimp so that the shrimp cook evenly.\n" +
                "Brush shrimp with a thin coating of olive oil on both sides\n" +
                "5 Grill the shrimp: Brush hot grill with a wadded up paper towel soaked in olive oil. Place the skewers of shrimp on the hot grill. Grill for 2-5 minutes per side, depending on how hot your grill is and how big your shrimp are.\n" +
                "The cut end of the shrimp will change from translucent to opaque as it cooks. It's done when it is just barely opaque. Take it off the grill. Don't overcook or your shrimp will be rubbery!\n" +
                "Remove the shrimp from the skewers when they are still relatively hot (they'll slide off better when warm). \n" +
                "6 Warm the tortillas: Depending on the type of tortilla you are using (flour tortillas work well, as do soft white corn tortillas), you can put them on the grill for a few moments to toast them just a little on each side.\n" +
                "You can also warm tortillas in a microwave (works well to soften them), or in a frying pan. If warming corn tortillas in a frying pan, it helps to add a little oil to the pan.\n" +
                "To serve, place a few shrimp in the center of a tortilla and top with mango avocado salsa!\n");

        Notes grilledShrimpTacosNotes = new Notes();
        grilledShrimpTacosNotes.setRecipeNotes("Large shrimp grill best (they are less likely to dry out). Look for 16/20 count shrimp (that's 16-20 shrimp per pound). Don't attempt to grill shrimp that are smaller than 26/30 count.\n" +
                "We suggest using peeled and deveined shrimp because of the convenience. But truly the best flavor will come from leaving the shell on while grilling. You can cut the back with sharp scissors and devein them before grilling if you want to leave the shells on. The shrimp will absorb flavor from the cooking shell, and it holds the moisture better.\n" +
                "We defrost shrimp in salty cold water because soaking in water is the fastest way to defrost shrimp, and if you soak the shrimp in plain water it will leach out the natural salt in the shrimp. The salty water helps the shrimp maintain their natural salt.\n" +
                "Read more: http://www.simplyrecipes.com/recipes/grilled_shrimp_tacos_with_mango_avocado_salsa/#ixzz4rXn3zRyQ");

        grilledShrimpTacosNotes.setRecipe(shrimpTacosRecipe);
        shrimpTacosRecipe.setNotes(grilledShrimpTacosNotes);

        // Add ingredients
        shrimpTacosRecipe.getIngredients().add(new Ingredient("pound shrimp (16/20 count) peeled and deveined (frozen is fine)", new BigDecimal(1), poundUom, shrimpTacosRecipe));
        shrimpTacosRecipe.getIngredients().add(new Ingredient("water", new BigDecimal(4), cupUom, shrimpTacosRecipe));
        shrimpTacosRecipe.getIngredients().add(new Ingredient("kosher salt", new BigDecimal(1), tableSpoonUom, shrimpTacosRecipe));
        shrimpTacosRecipe.getIngredients().add(new Ingredient("cubed ice", new BigDecimal(1), cupUom, shrimpTacosRecipe));
        shrimpTacosRecipe.getIngredients().add(new Ingredient("ripe but still firm mango, peeled and cut into small cubes", new BigDecimal(1), eachUom, shrimpTacosRecipe));
        shrimpTacosRecipe.getIngredients().add(new Ingredient("ripe avocado, seeded, peeled, and cut into small cubes", new BigDecimal(1), eachUom, shrimpTacosRecipe));
        shrimpTacosRecipe.getIngredients().add(new Ingredient("finely chopped red onion", new BigDecimal(1), tableSpoonUom, shrimpTacosRecipe));
        shrimpTacosRecipe.getIngredients().add(new Ingredient("fresh jalapeño pepper (less or more to taste), minced", new BigDecimal(0.5), eachUom, shrimpTacosRecipe));
        shrimpTacosRecipe.getIngredients().add(new Ingredient("fresh lime or lemon juice", new BigDecimal(3), tableSpoonUom, shrimpTacosRecipe));
        shrimpTacosRecipe.getIngredients().add(new Ingredient("kosher salt", new BigDecimal(0.5), teaSpoonUom, shrimpTacosRecipe));
        shrimpTacosRecipe.getIngredients().add(new Ingredient("chopped fresh cilantro leaves (optional)", new BigDecimal(2), tableSpoonUom, shrimpTacosRecipe));
        shrimpTacosRecipe.getIngredients().add(new Ingredient("corn or flour tortillas", new BigDecimal(11), eachUom, shrimpTacosRecipe));

        // Add categories
        shrimpTacosRecipe.getCategories().add(italianCategory);
        shrimpTacosRecipe.getCategories().add(scandinavianCategory);

        // Add to return list
        recipes.add(shrimpTacosRecipe);

        return recipes;
    }
}
