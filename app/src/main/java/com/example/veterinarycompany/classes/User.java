package com.example.veterinarycompany.classes;

public class User {

    private String names, username, password;
    private int id;

    public User(String names, String username, String password, int id) {
        this.names = names;
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
