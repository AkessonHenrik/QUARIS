package ch.heigvd.amt.services.dao;

import ch.heigvd.amt.models.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Stores all users
@Stateless
public class UserManager implements UserManagerLocal {

    @Resource(lookup = "java:/jdbc/quarisDS")
    private DataSource dataSource;

    protected Connection connection;

    /**
     * Check if the given user exists
     * @param username
     * @return If the user exists
     */
    public boolean exists(String username) {
        try {
            connection = dataSource.getConnection();

            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT COUNT(1) as 'res' FROM users WHERE username = ?");
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // If COUNT is "1" or more, user exists
                return !rs.getString("res").equals("0");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Get all users
     * @return List of all users
     */
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        PreparedStatement pstmt;

        try {
            connection = dataSource.getConnection();

            pstmt = connection.prepareStatement("SELECT * FROM users");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                users.add(new User(rs.getString("email"), rs.getString("username"), rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    /**
     * Get a specific user from his username
     * @param username
     * @return
     */
    public User getUserByUsername(String username) {
        try {
            Connection conn = dataSource.getConnection();

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String email = rs.getString("email");
                String username2 = rs.getString("username");
                String hashedPassword = rs.getString("password");

                return new User(email, username2, hashedPassword, true);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Add a new user to the database
     * @param user
     * @return If the user was added or not
     */
    public boolean addUser(User user) {
        boolean result = false;

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO users (email, username, password) VALUES (?, ?, ?)");

            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());

            result = pstmt.executeUpdate() > 0;

            conn.close();
        } catch (SQLIntegrityConstraintViolationException e) {
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Add a new user to the database
     * @param user
     * @return If the user was added or not
     */
    public boolean updateByUsername(final String username, User user) {
        boolean result = false;

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE users SET email = ?, username = ?, password = ? WHERE username = ?");

            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, username);

            result = pstmt.executeUpdate() > 0;

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Delete a specific user
     * @param username
     * @return
     */
    public boolean deleteByUsername(final String username) {
        boolean result = false;

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM users WHERE username = ?");
            pstmt.setString(1, username);

            result = pstmt.executeUpdate() > 0;

            conn.close();

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
