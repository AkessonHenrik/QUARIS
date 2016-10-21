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

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    /**
     * Show user info
     */
    public String toString() {
        return "User{username: " + username + ", email: " + email + "}";
    }

}
