package com.example.solutionsproject.classes.authentication;

import com.example.solutionsproject.classes.general.User;

public class DemoAuthentication implements AuthenticationSystem<User> {
    private final String email;
    private final String password;

    public DemoAuthentication(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public User login() {
        return new User(email, password);
    }

    @Override
    public User register() {
        return new User(email, password);
    }
}
