package pl.sda.intermediate.app.login;

import org.apache.commons.codec.digest.DigestUtils;
import pl.sda.intermediate.app.users.User;
import pl.sda.intermediate.app.users.UserDAO;

public class LoginService {
    private UserDAO userDAO;

    public LoginService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean login(LoginDTO dto){
        return userDAO.findUserByEmail(dto.getLogin())
                .map(e -> compareHashes(dto, e))
                .orElse(false);
    }

    private boolean compareHashes(LoginDTO dto, User e) {
        return e.getPasswordHash().equals(DigestUtils.sha512Hex(dto.getPassword()));
    }
}
