package com.example.myfirstproject.firstproject.service;
import com.example.myfirstproject.firstproject.entity.Admin;
import com.example.myfirstproject.firstproject.entity.AuthToken2;
import com.example.myfirstproject.firstproject.repository.AdminRepo;
import com.example.myfirstproject.firstproject.repository.AuthTokenRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepository;
    @Autowired
    private AuthTokenRepository2 authTokenRepository2;
    @Override
    public void saveAuthToken(AuthToken2 authToken) {
        // Save the AuthToken entity in the database
        authTokenRepository2.save(authToken);
    }

    public boolean login(String empCode, String password) {
        Admin login = adminRepository.findByEmpCodeAndOrgId(empCode);
        // System.out.println("zuffg");
        return login != null && login.getPassword().equals(password);
    }

    @Override
    public Admin registerAdmin(Admin admin) {
        // You can add validation logic here before saving to the database
        return adminRepository.save(admin);
    }
    @Override
    public Admin findByUsernameAndPassword(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);
    }
    @Override
    public boolean isAlreadyLoggedIn(String username) {
        List<AuthToken2> activeTokens = authTokenRepository2.findAll();

        for (AuthToken2 token : activeTokens) {
            Admin login = token.getLogin();
            if (login != null && login.getUsername().equals(username)) {
                // User is already logged in
                return true;
            }
        }

        // User is not logged in
        return false;
    }
}

