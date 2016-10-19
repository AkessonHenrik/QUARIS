package ch.heigvd.amt.models;

import javax.servlet.http.HttpSession;

public class User {
    private String username, email, password;
    private HttpSession sessionId;

    public User(String email, String username, String password, HttpSession sessionId) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.sessionId = sessionId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public HttpSession getSessionId() {
        return sessionId;
    }

    public void setSessionId(HttpSession sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "User{username: " + username + ", password: " + password + "}";
    }

}
