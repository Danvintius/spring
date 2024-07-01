package ru.netology.springbootdemo.domain;

import java.util.List;

public class User {
    public String name;
    public String password;
    private List<Authorities> authorities;

    public User(String name, String password, List<Authorities> authorities) {
        this.name = name;
        this.password = password;
        this.authorities = authorities;
    }

    ;

    public List<Authorities> getAuthorities() {
        return authorities;
    }
}

