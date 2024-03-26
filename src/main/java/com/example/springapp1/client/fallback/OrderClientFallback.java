package com.example.springapp1.client.fallback;

import com.example.springapp1.client.OrderClient;
import com.example.springapp1.model.entity.Order;
import com.example.springapp1.model.web.LensOrderParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;

@Slf4j
@Component
public class OrderClientFallback implements FallbackFactory<OrderClient> {

    @Override
    public OrderClient create(Throwable cause) {
        return new OrderClient() {
            @Override
            public Optional<Order> createOrder(String userId, List<LensOrderParams> params) {
                return empty();
            }

            @Override
            public Optional<Order> getOrder(String id) {
                return empty();
            }
        };
    }
}
