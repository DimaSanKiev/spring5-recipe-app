package guru.springframework.recipe.converter;

import guru.springframework.recipe.command.CategoryCommand;
import guru.springframework.recipe.model.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {

    private static final Long ID_VALUE = 1L;
    private static final String CATEGORY_NAME = "category name";
    private CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() throws Exception {
        // given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setCategoryName(CATEGORY_NAME);

        // when
        Category category = converter.convert(categoryCommand);

        // then
        assertNotNull(category);
        assertEquals(ID_VALUE, category.getId());
        assertEquals(CATEGORY_NAME, category.getCategoryName());
    }

}