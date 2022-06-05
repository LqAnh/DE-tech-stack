package com.example.anhlq.springbot.service;

import com.example.anhlq.springbot.model.Users;

import java.util.List;

public interface UserService {
    List<Users> getAllUser();

    Users findUser(long id);

    Users createUser(Users employee);

    Users updateUser(long id, Users employee);

    void delUser(long id);

    Users findEmail(String email);


}
