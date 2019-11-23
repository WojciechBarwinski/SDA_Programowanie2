package pl.sda.intermediate;

import java.util.*;

public class UserDAO {

    private Map<String, User> usersMap = new HashMap<>();

    public void addUser(User user){
        usersMap.put(user.getEMail(), user);
    }

    public boolean emailExists(String email){
        return usersMap.containsKey(email);
    }
}
