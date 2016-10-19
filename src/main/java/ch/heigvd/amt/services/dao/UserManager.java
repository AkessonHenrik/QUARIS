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

    // Checks if the user whose username and password are given is in the registered users list
    // If so, updates the user's session id
    // If not, returns false
    public boolean checkUser(String username, String password, HttpSession sessionId) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                u.setSessionId(sessionId);
                return true;
            }
        }
        return false;
    }

    // Compares the parameter sessionId with all registered user's session id
    public boolean compareSessions(HttpSession session) {
        for (User u : users) {
            try {
                if (u.getSessionId().equals(session))
                    return true;
            } catch (NullPointerException npe) {
            }
        }
        return false;
    }


    // Checks if the parameter session is registered to a user
    public boolean isLogged(HttpSession session) {
        if (users.isEmpty())
            return false;
        for (User u : users) {
            try {
                if (u.getSessionId().equals(session))
                    return true;
            } catch (NullPointerException npe) {

            }
        }
        return false;
    }

    // Sets to null the sessionId of the user associated with the parameter sessionId
    public void logout(HttpSession session) {
        for (User u : users) {
            try {
                if (u.getSessionId().equals(session)) {
                    u.setSessionId(null);
                    System.out.println("Logged " + u.getUsername() + " out");
                }
            } catch (NullPointerException npe) {
                System.out.println("Wasn't logged in");
            }
        }
    }

    // Adds a user to the list
    public boolean addUser(String email, String username, String password, HttpSession sessionId) {
        return users.add(new User(email, username, password, sessionId));
    }

    public boolean addUser(User user) {
        boolean result = false;

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO user (email, username, password) VALUES (?,?,?)");

            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());

            result = pstmt.execute();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;

    }

    public boolean exists(String username) {
        try {
            connection = dataSource.getConnection();

            PreparedStatement pstmt = connection.prepareStatement("SELECT COUNT(1) as 'res' FROM users WHERE username = ?");
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("res").equals("1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

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

    public User getUserbyName(String username) {
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

}
