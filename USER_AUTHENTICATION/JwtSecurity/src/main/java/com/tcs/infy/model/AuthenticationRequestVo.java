package com.tcs.infy.model;

public class AuthenticationRequestVo {

    private String username;
    private String password;

    public AuthenticationRequestVo(){ }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
