package pl.sda.intermediate;

import java.io.*;
import java.util.*;

public class UserDAO {
    private String filePath = "/home/kf/usersMap.txt";

    private Map<String, User> usersMap = readUsersFromFile();

    private Map<String, User> readUsersFromFile() {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (Map<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    public void addUser(User user) {
        usersMap.put(user.getEMail(), user);
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(usersMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean emailExists(String email) {
        return usersMap.containsKey(email);
    }

    public Optional<User> findUserByEmail(String login) {
        return Optional.ofNullable(usersMap.get(login));
    }
}
