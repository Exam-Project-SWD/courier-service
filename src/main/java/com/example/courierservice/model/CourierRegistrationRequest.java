package com.example.courierservice.model;

public record CourierRegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String phone,
        String password
) {
}
