package guru.springframework.recipe.bootstrap;

import guru.springframework.recipe.model.Category;
import guru.springframework.recipe.model.UnitOfMeasure;
import guru.springframework.recipe.repostitory.CategoryRepository;
import guru.springframework.recipe.repostitory.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"dev", "prod"})
public class BootstrapMySQL implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootstrapMySQL(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if (categoryRepository.count() == 0L) {
            log.debug("Loading categories");
            loadCategories();
        }

        if (unitOfMeasureRepository.count() == 0L) {
            log.debug("Loading UOMs");
            loadUoms();
        }
    }

    private void loadCategories() {
        Category cat1 = new Category();
        cat1.setCategoryName("Ukrainian");
        categoryRepository.save(cat1);

        Category cat2 = new Category();
        cat2.setCategoryName("Scandinavian");
        categoryRepository.save(cat2);

        Category cat3 = new Category();
        cat3.setCategoryName("American");
        categoryRepository.save(cat3);

        Category cat4 = new Category();
        cat4.setCategoryName("French");
        categoryRepository.save(cat4);

        Category cat5 = new Category();
        cat5.setCategoryName("Australian");
        categoryRepository.save(cat5);

        Category cat6 = new Category();
        cat6.setCategoryName("Italian");
        categoryRepository.save(cat6);

        Category cat7 = new Category();
        cat7.setCategoryName("Mexican");
        categoryRepository.save(cat7);

        Category cat8 = new Category();
        cat8.setCategoryName("Fast Food");
        categoryRepository.save(cat8);
    }

    private void loadUoms() {
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setDescription("Each");
        unitOfMeasureRepository.save(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setDescription("Teaspoon");
        unitOfMeasureRepository.save(uom2);

        UnitOfMeasure uom3 = new UnitOfMeasure();
        uom3.setDescription("Tablespoon");
        unitOfMeasureRepository.save(uom3);

        UnitOfMeasure uom4 = new UnitOfMeasure();
        uom4.setDescription("Cup");
        unitOfMeasureRepository.save(uom4);

        UnitOfMeasure uom5 = new UnitOfMeasure();
        uom5.setDescription("Pinch");
        unitOfMeasureRepository.save(uom5);

        UnitOfMeasure uom6 = new UnitOfMeasure();
        uom6.setDescription("Ounce");
        unitOfMeasureRepository.save(uom6);

        UnitOfMeasure uom7 = new UnitOfMeasure();
        uom7.setDescription("Grams");
        unitOfMeasureRepository.save(uom7);

        UnitOfMeasure uom8 = new UnitOfMeasure();
        uom8.setDescription("Dash");
        unitOfMeasureRepository.save(uom8);

        UnitOfMeasure uom9 = new UnitOfMeasure();
        uom9.setDescription("Pint");
        unitOfMeasureRepository.save(uom9);

        UnitOfMeasure uom10 = new UnitOfMeasure();
        uom10.setDescription("Pound");
        unitOfMeasureRepository.save(uom10);


    }
}
