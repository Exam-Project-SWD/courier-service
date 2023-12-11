package com.example.courierservice.repository;

import com.example.courierservice.model.entity.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Integer> {
    Courier findByEmail(String email);
}
