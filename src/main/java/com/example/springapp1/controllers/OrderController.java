package com.example.springapp1.controllers;

import com.example.springapp1.model.dto.OrderDto;
import com.example.springapp1.model.web.LensOrderParams;
import com.example.springapp1.services.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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

                                                @RequestBody @Valid
                                                @NotEmpty(message = "Выберите линзы для заказа")
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
