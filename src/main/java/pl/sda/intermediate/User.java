package pl.sda.intermediate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class User {

    private String firstName;
    private String lastName;
    private String eMail;
    private String passwordHash;
    private String city;
    private String country;
    private String zipCode;
    private String street;
    private String birthDate;
    private String pesel;
    private String phone;
    private Boolean preferEmails;
}
