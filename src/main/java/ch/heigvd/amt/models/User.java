package ch.heigvd.amt.models;

import javax.servlet.http.HttpSession;

public class User {
    private String username, password;
    private HttpSession sessionId;

    public User(String username, String password, HttpSession sessionId) {
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
