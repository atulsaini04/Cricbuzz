package com.example.myfirstproject.firstproject.service;

import com.example.myfirstproject.firstproject.entity.Admin;
import com.example.myfirstproject.firstproject.entity.AuthToken2;

public interface AdminService {
    boolean login(String username, String password);
    void saveAuthToken(AuthToken2 authToken);

    Admin registerAdmin(Admin admin);
    Admin findByUsernameAndPassword(String username, String password);
    boolean isAlreadyLoggedIn(String username);

}

