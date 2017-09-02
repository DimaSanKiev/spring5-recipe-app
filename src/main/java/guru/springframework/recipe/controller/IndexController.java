package guru.springframework.recipe.controller;

import guru.springframework.recipe.model.Category;
import guru.springframework.recipe.model.UnitOfMeasure;
import guru.springframework.recipe.repostitory.CategoryRepository;
import guru.springframework.recipe.repostitory.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByCategoryName("Ukrainian");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category ID is: " + categoryOptional.get().getId());
        System.out.println("UnitOfMeasure ID is: " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
