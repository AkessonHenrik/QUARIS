package ch.heigvd.amt.services.dao;

import ch.heigvd.amt.models.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Stores all users
@Stateless
public class UserManager implements UserManagerLocal {

    @Resource(lookup = "java:/jdbc/quarisDS")
    private DataSource dataSource;

    protected Connection connection;

    // Users are kept here
    private static LinkedList<User> users = new LinkedList<>();

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
                // If COUNT is "1", user exists
                return rs.getString("res").equals("1");
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
                users.add(new User(rs.getString("email"), rs.getString("username"), rs.getString("password"), null));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public User getUserByUsername(String username) {
        try {
            Connection conn = dataSource.getConnection();

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                String username2 = rs.getString("username");

                return new User(username2, email, password, null);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
