package Cricbuzz.service;


import Cricbuzz.entity.Admin;
import Cricbuzz.entity.AuthToken;

public interface AdminService {
    boolean login(String username, String password);
    void saveAuthToken(AuthToken authToken);

    Admin registerAdmin(Admin admin);
    Admin findByUsernameAndPassword(String username, String password);
    boolean isAlreadyLoggedIn(String username);

}

