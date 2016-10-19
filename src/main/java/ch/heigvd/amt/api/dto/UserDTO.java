package ch.heigvd.amt.api.dto;

import ch.heigvd.amt.models.User;

public class UserDTO {
    private String email, username, password;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
}
