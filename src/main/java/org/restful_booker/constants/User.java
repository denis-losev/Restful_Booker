package org.restful_booker.constants;

public class User {
    private String username = "admin";
    private String password = "password123";

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
        setPassword(password);
        setUsername(username);
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
}
