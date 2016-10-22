package ch.heigvd.amt.services.dao;

import ch.heigvd.amt.models.User;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface UserManagerLocal {
    boolean addUser(User user);

    User getUserByUsername(String username);

    boolean exists(String username);

    List<User> getAll() throws SQLException;

    boolean deleteByUsername(String username);

    boolean updateByUsername(String username, User oldUser);
}
