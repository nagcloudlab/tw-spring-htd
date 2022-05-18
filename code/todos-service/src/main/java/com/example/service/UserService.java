package com.example.service;

import com.example.entity.User;

public interface UserService {

    User signup(String name);
    User signin(String username,String password);

}
