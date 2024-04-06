package com.example.myfirstproject.firstproject.controller;
import com.example.myfirstproject.firstproject.TOs.AdminResponseTO;
import com.example.myfirstproject.firstproject.TOs.ErrorResponse;
import com.example.myfirstproject.firstproject.TOs.LoginRequest;
import com.example.myfirstproject.firstproject.TOs.LoginResponse;
import com.example.myfirstproject.firstproject.entity.Admin;
import com.example.myfirstproject.firstproject.entity.AuthToken2;
import com.example.myfirstproject.firstproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;
    private Admin admin;
    private static final String secretKey = "my-key"; // Replace with your actual secret key


    @PostMapping("/admin/register")
    public ResponseEntity<?> registerAdmin(@RequestBody Admin admin) {
        Admin registeredAdmin = adminService.registerAdmin(admin);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new AdminResponseTO("Admin Account successfully created", HttpStatus.OK.value(), registeredAdmin.getId()));
    }

    @PostMapping("/admin/login")
    public ResponseEntity<?> loginAdmin(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        if (admin != null) {
            boolean isAlreadyLoggedIn = adminService.isAlreadyLoggedIn(username);
            if (isAlreadyLoggedIn) {
                // User is already logged in, return an error response
                LoginResponse loginStatusTO = new LoginResponse();
                loginStatusTO.setStatus("alreadyloggedin");

            }
            boolean isValidLogin = adminService.login(username, password);
            LoginResponse loginStatusTO = new LoginResponse();
            if (isValidLogin) {
                String emppassword = username + ":" + password;
                String authToken = generateAuthToken(emppassword, secretKey);

                AuthToken2 auth = new AuthToken2();
                auth.setToken(authToken);
                auth.setUsername(username);
                auth.setExpirationTime(LocalDateTime.now().plusMinutes(2));

                adminService.saveAuthToken(auth); // Save the auth token in the database

                loginStatusTO.setAuthToken(authToken);
                loginStatusTO.setStatus("loggedin");
                LoginResponse response = new LoginResponse("Login successful", HttpStatus.OK.value(), admin.getId(), authToken);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        }else {
            ErrorResponse response = new ErrorResponse("Incorrect username/password provided. Please retry", HttpStatus.UNAUTHORIZED.value());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        return null;
    }

    private String hashSHA256(String data) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = messageDigest.digest(data.getBytes());
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            // Handle hashing error
            e.printStackTrace();
            return null;
        }
    }

    private String generateAuthToken(String emppassword, String secretKey) {
        UUID uuid = UUID.randomUUID();
        String randomUUID = uuid.toString();

        String dataToHash = emppassword + secretKey + randomUUID;
        String hashedData = hashSHA256(dataToHash);
        return hashedData;
    }
}
