package ch.heigvd.amt.services;

import ch.heigvd.amt.model.User;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.util.LinkedList;

/**
 * Created by Henrik on 28.09.2016.
 */
public class UserManager {
    private static LinkedList<User> users = new LinkedList<>();

    public boolean checkUser(String username, String password, HttpSession sessionId) {
        for(User u : users) {
            if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                u.setSessionId(sessionId);
                return true;
            }
        }
        return false;
    }

    public boolean compareSessions(HttpSession session) {
        for(User u : users) {
            try {
                if (u.getSessionId().equals(session))
                    return true;
            } catch(NullPointerException npe) {
                return false;
            }
        }
        return false;
    }
    public boolean isLogged(HttpSession session) {
        if(users.isEmpty())
            return false;
        for(User u : users) {
            try {
                if (u.getSessionId().equals(session))
                    return true;
            }catch(NullPointerException npe) {

            }
        }
        return false;
    }
    public void logout(HttpSession session) {
        for(User u : users) {
            try {
                if (u.getSessionId().equals(session)) {
                    u.setSessionId(null);
                    System.out.println("Logged " + u.getUsername() + " out");
                }
            } catch(NullPointerException npe) {
                System.out.println("Wasn't logged in");
            }
        }
    }

    public void addUser(String username, String password, HttpSession sessionId) {
        users.add(new User(username, password, sessionId));
    }
}
