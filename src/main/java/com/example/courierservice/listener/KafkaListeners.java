package com.example.courierservice.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaListeners {

    @KafkaListener(topics = "ORDER_AVAILABLE", groupId = "order-available-id")
    public void      getAvailableOrder(String message) {
        System.out.println(message);
    }
}
