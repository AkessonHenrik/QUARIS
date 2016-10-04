package ch.heigvd.amt.services;

import ch.heigvd.amt.model.User;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;

// Stores all users
public class UserManager {

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
    public void addUser(String username, String password, HttpSession sessionId) {
        users.add(new User(username, password, sessionId));
    }
}
