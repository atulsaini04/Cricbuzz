package com.example.myfirstproject.firstproject.TOs;
public class ErrorResponse {
    private String status;
    private int statusCode;

    public ErrorResponse() {
    }

    public ErrorResponse(String status, int statusCode) {
        this.status = status;
        this.statusCode = statusCode;
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
}
