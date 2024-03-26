package com.example.springapp1.client;

import com.example.springapp1.client.fallback.LensClientFallback;
import com.example.springapp1.model.entity.Order;
import com.example.springapp1.model.web.LensOrderParams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(url = "${feignUrl}/orders", fallbackFactory = LensClientFallback.class)
public interface OrderClient {

    @PostMapping
    Optional<Order> createOrder(@RequestParam String userId, @RequestBody List<LensOrderParams> params);

    @GetMapping("/{id}")
    Optional<Order> getOrder(@PathVariable String id);
}