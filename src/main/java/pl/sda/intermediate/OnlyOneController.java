package pl.sda.intermediate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.security.sasl.Sasl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/register",method = RequestMethod.GET) //to jest url na który metoda reaguje - po wejsciu na niego wyswietli sie strona registerPage
    public String registerForm(Model model){//model zapewniony przez Spring
        RegistrationDTO registrationDTO = new RegistrationDTO(); //pusty obiekt na dane (formularz)
        model.addAttribute("form", registrationDTO);
        model.addAttribute("countries", Countries.values());


        return "registerPage";//to jest nazwa strony html jaka nam sie wyswietli
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerEffect(RegistrationDTO registrationDTO, Model model){ //metoda reagująca na wysłanie formularza rejestracji, registrationDto zostaje uzupełniony przez użytkownika
        RegistrationValidationService registrationValidationService = new RegistrationValidationService();
        Map<String, String> errorsMap = registrationValidationService.validate(registrationDTO);
        if(errorsMap.isEmpty()){
            RegistrationService registrationService = new RegistrationService();
            registrationService.register(registrationDTO);
            return "";
        }else {
            model.addAllAttributes(errorsMap);
            model.addAttribute("form", registrationDTO);
            model.addAttribute("countries", Countries.values());
            return "registerPage";
        }
    }



}
