package pl.sda.intermediate.app.registration;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class RegistrationValidationService { //todo test

    public Map<String, String> validate(RegistrationDTO dto){
        Map<String, String> errorsMap = new HashMap<>();
        if(!dto.getFirstName().matches("^[A-Z][a-z]{2,}$")){
            errorsMap.put("firstNameValRes", "Imię jest wymagane. " +
                    "Przynajmniej 3 znaki oraz pierwsza duża, reszta małe.");

        }
        if(!dto.getLastName().matches("^[A-Z][a-z]{2,}(-[A-Z][a-z]{2,})?$")){
            errorsMap.put("lastNameValRes", "Nazwisko jest wymagane. Przynajmniej 3 znaki oraz pierwsza duża, reszta małe \n" +
                    "\t+ dopuszczenie \"-\" i drugiego członu z dużej litery");
        }

        if (!dto.getZipCode().matches("^[0-9]{2}-[0-9]{3}$")){
            errorsMap.put("zipCodeValRes", "Zły format. Kod pocztowy powinien mieć format 12-345. \n");
        }
        if (StringUtils.isBlank(dto.getCity())) {
            errorsMap.put("cityValRes", "Miasto wymagane \n");
        }
        if (StringUtils.isBlank(dto.getCountry())) {
            errorsMap.put("countryValRes", "Kraj wymagany \n");
        }
        if (StringUtils.isBlank(dto.getStreet())) {
            errorsMap.put("streetValRes", "Ulica wymagana \n");
        }
        if (!dto.getBirthDate().matches("^(19|20)[\\d]{2}-(0[1-9]|1[012])-(0[1-9]|[12][\\d]|3[01])$")){
            errorsMap.put("birthDateValRes", "Zły format. Data urodzin powinna być podana w formacie RRRR-MM-DD\n");
        }
        if (!dto.getPesel().matches("[0-9]{11}$")){
            errorsMap.put("peselValRes", "Zły format. Numer PESEL powinien składać się z 11 cyfr.");
        }

        if (!dto.getEMail().matches("^[\\w._+]{3,}@[\\w]{2,}(\\.[\\w]{2,}){1,2}$")){
            errorsMap.put("eMailValRes", "Zły format adresu email\n");
        }
        if (!dto.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{10,20}$")) {
            errorsMap.put("passwordValRes", "Hasło jest wymagane. Musi zawierać od 10 do 20 znaków. \n" +
                    "Minimum jedna duża, jedna mała litera i jedna cyfra.");
        }

        if (!dto.getPhone().matches("^(\\+[0-9]{1,3} )?(((([0-9]{3})(-)){2}[0-9]{3})|([0-9]{9}))$")){
            errorsMap.put("phoneValRes", "Zły format. Numer telefonu powinien składać się z 9 cyfr z myślnikami. \n" +
                    "\t-> możliwa opcja z \"+48\" na początku\", ");
        }

        return errorsMap;
    }


}
