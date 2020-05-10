package Data;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class UserPassDTO {
    String username;
    String password;

    public UserPassDTO(){}

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
}
