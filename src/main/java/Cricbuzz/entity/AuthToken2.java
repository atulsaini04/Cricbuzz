package com.example.myfirstproject.firstproject.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AuthToken2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token")
    private String token;
    @ManyToOne
    @JoinColumn(name = "emp_code", referencedColumnName = "emp_code", insertable = false, updatable = false)
    private Admin login;
    @Column(name = "user_name")
    private String username;
    @Column(name = "expiration_time")
    private LocalDateTime expirationTime;



    public AuthToken2() {}

    public AuthToken2(Long id, String token, Admin login, String username, LocalDateTime expirationTime) {
        this.id = id;
        this.token = token;
        this.login = login;
        this.username = username;
        this.expirationTime = expirationTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Admin getLogin() {
        return login;
    }

    public void setLogin(Admin login) {
        this.login = login;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }
}
