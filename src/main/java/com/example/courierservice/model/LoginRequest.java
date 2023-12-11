package com.example.courierservice.model;

public record LoginRequest(
        String email,
        String password
) {
}
