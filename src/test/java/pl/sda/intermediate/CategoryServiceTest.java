package pl.sda.intermediate;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    @Test
    void shouldMarkAsOpen() {

        String name = "Lektury";

        CategoryService categoryService = new CategoryService();
        List<CategoryDTO> categoryDTOS = categoryService.findCategories(name);

        System.out.println(categoryDTOS);
    }

    @Test
    void shouldMarkAsOpenWhenNameIsNull() {

        String name = null;

        CategoryService categoryService = new CategoryService();
        List<CategoryDTO> categoryDTOS = categoryService.findCategories(name);

        System.out.println(categoryDTOS);
    }
}