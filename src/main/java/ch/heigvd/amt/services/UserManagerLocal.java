package ch.heigvd.amt.services;

import ch.heigvd.amt.models.User;

import javax.ejb.Local;
import javax.servlet.http.HttpSession;
import java.util.List;

@Local
public interface UserManagerLocal {
    boolean checkUser(String username, String password, HttpSession session);

    boolean isLogged(HttpSession session);

    void logout(HttpSession session);

    void addUser(String username, String password, HttpSession session);

    void addUser(User user);

    User getUserbyName(String username);

    boolean exists(String username);

    List<User> getAll();
}
