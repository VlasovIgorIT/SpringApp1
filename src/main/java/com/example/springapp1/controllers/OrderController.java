package com.example.springapp1.controllers;


import com.example.springapp1.models.dto.OrderDto;
import com.example.springapp1.models.web.LensOrderParams;
import com.example.springapp1.services.OrderService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class OrderController {

    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestHeader
                                                String sessionId,

                                                @RequestBody
                                                @NotEmpty(message = "")
                                                List<LensOrderParams> lensOrderParams) {
        return status(CREATED)
                .body(orderService.createOrder(sessionId, lensOrderParams));
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrders(@RequestHeader String sessionId) {
        return ok(orderService.getOrders(sessionId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getById(@PathVariable String id) {
        return ok(orderService.getOrder(id));
    }
}
