package Models;

public class User {
    private String username;
    private String password;
    private String error = new String("Default Error");

    public User() {
    }

    public User(String username, String password, String error) {
        this.username = username;
        this.password = password;
        this.error += error;
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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
