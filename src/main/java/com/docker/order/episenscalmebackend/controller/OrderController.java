package com.docker.order.episenscalmebackend.controller;

import com.docker.order.episenscalmebackend.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    @PostMapping("/add/order")
    public ResponseEntity<String> add_order(@RequestParam String text){
        logger.info("Post request add/order. Go try to insert: "+text);
        return orderService.getStringResponseEntity(text);
    }


}
