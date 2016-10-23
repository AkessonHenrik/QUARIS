/**
 * @author Henrik Akesson
 * @author Fabien Salathe
 */
package ch.heigvd.amt.api.dto;

import ch.heigvd.amt.models.User;

public class UserDTO {
    private String username, email, password;

    public UserDTO() {
    }

    public UserDTO(final User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
}
