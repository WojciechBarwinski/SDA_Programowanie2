package pl.sda.intermediate;

import org.apache.commons.codec.digest.DigestUtils;

public class RegistrationService {

    public void register(RegistrationDTO dto) {
        UserDAO userDAO = new UserDAO();
        if (userDAO.emailExists(dto.getEMail())) {
            throw new RuntimeException("Email istnieje: " + dto.getEMail());
        }

        User user = buildUserFromDTO(dto);
        userDAO.addUser(user);
    }

    private User buildUserFromDTO(RegistrationDTO dto) {
        User user = new User();
        user.setBirthDate(dto.getBirthDate());
        user.setCity(dto.getCity());
        user.setCountry(dto.getCountry());
        user.setEMail(dto.getEMail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPasswordHash(DigestUtils.sha512Hex(dto.getPassword()));
        user.setPesel(dto.getPesel());
        user.setPhone(dto.getPhone());
        user.setPreferEmails(dto.getPreferEmails());
        user.setZipCode(dto.getZipCode());
        user.setStreet(dto.getStreet());
        return user;
    }
}