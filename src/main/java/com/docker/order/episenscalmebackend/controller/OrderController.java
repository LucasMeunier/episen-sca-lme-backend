package com.docker.order.episenscalmebackend.controller;

import com.docker.order.episenscalmebackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add/order")
    public ResponseEntity<String> add_order(@RequestParam String text){
        System.out.println("test + "+text);
        return orderService.getStringResponseEntity(text);
    }


}
