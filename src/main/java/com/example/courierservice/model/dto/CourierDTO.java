package com.example.courierservice.model.dto;

import com.example.courierservice.model.entity.Courier;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourierDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;

    public CourierDTO(Courier courier) {
        this.firstName = courier.getFirstName();
        this.lastName = courier.getLastName();
        this.email = courier.getEmail();
        this.phone = courier.getPhone();
        this.password = courier.getPassword();

    }
}
