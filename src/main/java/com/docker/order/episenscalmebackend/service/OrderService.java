package com.docker.order.episenscalmebackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    public ResponseEntity<String> getStringResponseEntity(String text);
}
