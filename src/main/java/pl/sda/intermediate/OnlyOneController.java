package pl.sda.intermediate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.security.sasl.Sasl;
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

    @RequestMapping("/register") //to jest url na który metoda reaguje - po wejsciu na niego wyswietli sie strona registerPage
    public String registerForm(Model model){//model zapewniony przez Spring
        RegistrationDTO registrationDTO = new RegistrationDTO(); //pusty obiekt na dane (formularz)
        model.addAttribute("form", registrationDTO);
        model.addAttribute("countries", Countries.values());


        return "registerPage";//to jest nazwa strony html jaka nam sie wyswietli
    }


}
