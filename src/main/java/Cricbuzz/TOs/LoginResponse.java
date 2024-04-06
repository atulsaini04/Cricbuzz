package com.example.myfirstproject.firstproject.TOs;

    public class LoginResponse {
        private String status;
        private int statusCode;
        private Long userId;
        private String authToken;

        public LoginResponse() {
        }

        public LoginResponse(String status, int statusCode, Long userId, String authToken) {
            this.status = status;
            this.statusCode = statusCode;
            this.userId = userId;
            this.authToken = authToken;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getAuthToken() {
            return authToken;
        }

        public void setAuthToken(String authToken) {
            this.authToken = authToken;
        }
    }


