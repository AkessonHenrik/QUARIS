package ch.heigvd.amt.models;

public class User {
    private String username, email, password;

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    /**
     * Get username
     * @return Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get password // TODO - Secure that
     * @return Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get email
     * @return Email
     */
    public String getEmail() {
        return email;
    }

    @Override
    /**
     * Show user info
     */
    public String toString() {
        return "User{username: " + username + ", email: " + email + "}";
    }

}
