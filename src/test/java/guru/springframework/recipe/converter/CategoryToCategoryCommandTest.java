package guru.springframework.recipe.converter;

import guru.springframework.recipe.command.CategoryCommand;
import guru.springframework.recipe.model.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    private static final Long ID_VALUE = 1L;
    private static final String CATEGORY_NAME = "category name";
    private CategoryToCategoryCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convert() throws Exception {
        // given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setCategoryName(CATEGORY_NAME);

        // when
        CategoryCommand command = converter.convert(category);

        // then
        assertNotNull(command);
        assertEquals(ID_VALUE, command.getId());
        assertEquals(CATEGORY_NAME, command.getCategoryName());
    }

}