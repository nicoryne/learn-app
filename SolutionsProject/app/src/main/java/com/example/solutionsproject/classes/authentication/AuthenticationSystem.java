package com.example.solutionsproject.classes.authentication;

public interface AuthenticationSystem<T> {
    T login();
    T register();
}
