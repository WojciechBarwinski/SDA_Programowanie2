package pl.sda.intermediate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OnlyOneController {

    @RequestMapping("/categories")
    public String categoriesPage(@RequestParam String input, Model model) {
        CategoryService categoryService = new CategoryService();
        List<CategoryDTO> categories = categoryService.findCategories(input);
        model.addAttribute("catsdata", categories);
        return "catspage"; //to jest nazwa strony html jaka nam sie wyswietli
    }


    private List<String> history = new ArrayList<>();

    @RequestMapping("/hello")
    public String hello(@RequestParam(required = false) String personName, Model model) {
        history.add(personName);
        model.addAttribute("message", "Hello " + (personName == null ? "World" : personName));
        model.addAttribute("history", history);
        return "helloSite";
    }


}
