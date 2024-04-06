package com.example.myfirstproject.firstproject.TOs;
public class AdminResponseTO {
        private String status;
        private int statusCode;
        private Long userId;
//curl -X POST \
//  http://localhost:8080/admin/register \
//  -H 'Content-Type: application/json' \
//  -d '{
//	"username": "example_user",
//	"password": "example_password",
//	"email": "user@example.com"
//}'
        public AdminResponseTO(String status, int statusCode, Long userId) {
                this.status = status;
                this.statusCode = statusCode;
                this.userId = userId;
        }

        public AdminResponseTO() {
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
        // Constructors, getters, and setters
}
