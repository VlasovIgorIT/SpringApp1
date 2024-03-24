package com.example.springapp1.client;

import com.example.springapp1.client.fallback.UserClientFallback;
import com.example.springapp1.models.entity.Order;
import com.example.springapp1.models.entity.User;
import com.example.springapp1.models.web.LensOrderParams;
import com.example.springapp1.models.web.LoginParams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(url = "${feignUrl}", fallbackFactory = UserClientFallback.class)
public interface UserClient {

    @PostMapping("/login")
    Optional<User> getAuthorizedUser(@RequestBody LoginParams params);

    @GetMapping("/{userId}/orders")
    List<Order> getOrderList(@PathVariable String userId);

    @PostMapping("/{userId}")
    Optional<Order> createOrder(@PathVariable String userId, @RequestBody List<LensOrderParams> params);

    //TODO посмотреть один заказ
}