package Cricbuzz.service;

import Cricbuzz.entity.Admin;
import Cricbuzz.entity.AuthToken;
import Cricbuzz.repository.AdminRepo;
import Cricbuzz.repository.AuthTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepository;
    @Autowired
    private AuthTokenRepository authTokenRepository;
    @Override
    public void saveAuthToken(AuthToken authToken) {
        // Save the AuthToken entity in the database
        authTokenRepository.save(authToken);
    }

    public boolean login(String username, String password) {
        Admin login = adminRepository.findByusername(username);
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
        List<AuthToken> activeTokens = authTokenRepository.findAll();

        for (AuthToken token : activeTokens) {
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

