package pl.sda.intermediate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryDAO {

    private List<Category> categoryList;

    private CategoryDAO instance;

    private CategoryDAO() {
        categoryList = createCategories();
    }

    private List<Category> createCategories() {
        List<String> lines = readLinesFromFile();
        List<Category> categories = new ArrayList<>();
        int i = 1;
        for (String line : lines) {
            Category category = Category.builder()
                    .id(i++)
                    .name(line.trim())
                    .depth(line.split("\\S+")[0].length())
                    .build();
            categories.add(category);
        }
        return categories;
    }

    private List<String> readLinesFromFile() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL url = classLoader.getResource("Kategorie.txt");
        try {
            return Files.readAllLines(Paths.get(url.toURI()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
//        return new ArrayList<>(); //lepiej uzyc pustej (staycznej) niz zwracac za kazdym razem nową z 10 miejscami
        return Collections.emptyList();
    }

    public CategoryDAO getInstance() {
        if (instance == null) {
            synchronized (CategoryDAO.class) {
                if (instance == null) {
                    instance = new CategoryDAO();
                }
            }
        }
        return instance;
    }
}
