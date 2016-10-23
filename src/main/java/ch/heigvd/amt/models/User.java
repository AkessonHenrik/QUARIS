/**
 * @author Henrik Akesson
 * @author Fabien Salathe
 */
package ch.heigvd.amt.models;

import com.lambdaworks.crypto.SCryptUtil;

public class User {
    private String username, email, hashedPassword;

    /**
     * Constructor
     * @param email
     * @param username
     * @param password
     * @param isHashed If the password is already hashed
     */
    public User(String email, String username, String password, boolean isHashed) {
        this.email = email;
        this.username = username;

        if (isHashed) {
            this.hashedPassword = password;
        } else {
            this.hashedPassword = SCryptUtil.scrypt(password, 16, 16, 16);
        }
    }

    /**
     * Constructor
     * @param email Email
     * @param username Username
     * @param password Clear password
     */
    public User(String email, String username, String password) {
        this(email, username, password, false);
    }

    /**
     * Get username
     * @return Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Test if the given password is correct
     * @return Password
     */
    public boolean testPassword(String password2) {
        return SCryptUtil.check(password2, hashedPassword);
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

    /**
     * Set password (in clear)
     * @param password
     */
    public void setPassword(final String password) {
        this.hashedPassword = SCryptUtil.scrypt(password, 16, 16, 16);
    }

    /**
     * Set password (hashed with SCrypt)
     * @param password
     */
    public void setHashedPassword(final String password) {
        this.hashedPassword = password;
    }

    /**
     * Get password, hashed, hex encoded
     * @return
     */
    public String getPassword() {
        return hashedPassword;
    }

    @Override
    /**
     * Show user info
     */
    public String toString() {
        return "User{username: " + username + ", email: " + email + "}";
    }

}
