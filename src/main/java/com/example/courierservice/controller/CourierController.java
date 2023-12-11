package com.example.courierservice.controller;

import com.example.courierservice.model.CourierRegistrationRequest;
import com.example.courierservice.model.LoginRequest;
import com.example.courierservice.model.dto.CourierDTO;
import com.example.courierservice.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courier")
public class CourierController {
    private static final Logger LOGGER = LoggerFactory.getLogger(Authentication.class);
    @Autowired
    private CourierService courierService;

    @PostMapping("/register")
    public ResponseEntity<CourierDTO> registerCourier(@RequestBody CourierRegistrationRequest request) {
        return ResponseEntity.ok(courierService.registerCourier(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) throws Exception {
        LOGGER.debug("Request was made with email: " + request.email());
        String token = courierService.generateToken(request);
        return ResponseEntity.ok(token);
    }
}
