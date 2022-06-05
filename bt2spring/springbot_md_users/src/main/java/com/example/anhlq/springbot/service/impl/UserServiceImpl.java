package com.example.anhlq.springbot.service.impl;

import com.example.anhlq.springbot.exception.ApiRequestException;
import com.example.anhlq.springbot.model.Users;
import com.example.anhlq.springbot.repository.UserRepository;
import com.example.anhlq.springbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> getAllUser() {
        return (List<Users>) userRepository.findAll();
    }

    @Override
    public Users createUser(Users newUser) {
        if (!checkInput(newUser.getEmail(), newUser.getPassword())) {
            throw new ApiRequestException("Email And Password Can Not Be Empty Or Null");
        } else if (!checkEmail(newUser.getEmail())) {
            throw new ApiRequestException("Email Already Exists");
        } else {
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            userRepository.save(newUser);
            return newUser;
        }
    }

    @Override
    public Users updateUser(long id, Users newDetail) {
        Users updateEm = userRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("User Not Exist: " + id));
        updateEm.setEmail(newDetail.getEmail());
        updateEm.setPassword(passwordEncoder.encode(newDetail.getPassword()));

        if (!checkInput(newDetail.getEmail(), newDetail.getPassword())) {
            throw new ApiRequestException("Email And Password Can Not Be Empty Or Null");
        } else if (!checkEmail(newDetail.getEmail())) {
            throw new ApiRequestException("Email Already Exist");
        } else {
            userRepository.save(updateEm);

        }
        return updateEm;
    }

    @Override
    public Users findUser(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("User Not Found"));
    }

    @Override
    public void delUser(long id) {
        if (userRepository.findById(id).isPresent()) {

            userRepository.deleteById(id);
        } else {
            throw new ApiRequestException("User Not Exist: " + id);
        }
    }

    @Override
    public Users findEmail(String email) {
        return userRepository.findByEmail(email);
    }


    private boolean checkEmail(String email) {
        Users user = findEmail(email);
        return user == null;
    }

    private boolean checkInput(String email, String pass) {
        if (Objects.equals(email, "") || Objects.equals(pass, "")) {
            return false;
        } else if (email == null || pass == null) {
            return false;
        } else if (Objects.equals(email, "") && !Objects.equals(pass, "") || !Objects.equals(email, "") && Objects.equals(pass, "")) {
            return false;
        } else {
            return true;
        }
    }
}
