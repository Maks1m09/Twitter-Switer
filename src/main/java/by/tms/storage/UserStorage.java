package by.tms.storage;

import by.tms.model.Post;
import by.tms.model.User;
import by.tms.model.UserRole;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private static final List<User> users = new ArrayList<>();

    public List<User> getAllUser() {
            return new ArrayList<>(users); //все посты

    }

    public void save(User user){
        users.add(user);
    }

    public User findByLogin(String login) {
        for (User user : users) {
            if (user != null && user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public boolean isExistsByLogin(String login) {
        for (User user : users) {
            if (user != null && user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDeleteByLogin(String login) {
        for (User user : users) {
            if (user != null && user.getLogin().equals(login)) {
                users.remove(user.getUserId());
                return true;
            }
        }
        return false;
    }

}
