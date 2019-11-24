package pl.sda.intermediate;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Optional;

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
