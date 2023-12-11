package com.example.courierservice.service;

import com.example.courierservice.model.CourierRegistrationRequest;
import com.example.courierservice.model.LoginRequest;
import com.example.courierservice.model.dto.CourierDTO;
import com.example.courierservice.model.entity.Courier;
import com.example.courierservice.repository.CourierRepository;
import com.example.courierservice.util.JwtToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CourierService {
    private final CourierRepository courierRepository;
    private final PasswordEncoder encoder = new BCryptPasswordEncoder();
    private final JwtToken jwtToken;


    public CourierDTO registerCourier(CourierRegistrationRequest request) {
        //TODO: gRPC call to address service to find addressId

        Courier courier = Courier.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .password(encoder.encode(request.password()))
                .build();

        Courier newCourier = courierRepository.save(courier);

        return CourierDTO.builder()
                .firstName(newCourier.getFirstName())
                .lastName(newCourier.getLastName())
                .email(newCourier.getEmail())
                .phone(newCourier.getPhone())
                .password(newCourier.getPassword())
                .build();
    }

    public String generateToken(LoginRequest request) throws Exception {
        Courier courier = courierRepository.findByEmail(request.email());

        if (courier != null && authenticate(request.password(), courier.getPassword())) {
            //return generated token
            return jwtToken.generateToken(request.email());
        } else {
            throw new Exception("email does not exist in the database");
        }
    }

    public boolean authenticate(String inputPassword, String storedPassword) {
        return encoder.matches(inputPassword, storedPassword);
    }
}
