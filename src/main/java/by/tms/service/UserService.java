package by.tms.service;

import by.tms.model.Post;
import by.tms.model.User;
import by.tms.model.UserRole;
import by.tms.storage.UserStorage;

import java.util.List;

public class UserService {

    private static final UserStorage userStorage = new UserStorage();

    public List<User> findAllUser() {
        return userStorage.getAllUser();
    }

    public User changeUser (String login){
       User user = findUserByLogin(login);
       user.setRole(UserRole.USER_ROLE);
       return user;
    }


    public boolean add(User user) {
        if (user == null) { return false; }
        if (userStorage.isExistsByLogin(user.getLogin())) {
            return false;
        }
        userStorage.save(user);
        return true;
    }

    public User findUserByLogin(String login) {
        if (userStorage.findByLogin(login) != null && login != null) {
            return userStorage.findByLogin(login);
        }
        return null;
    }
}
