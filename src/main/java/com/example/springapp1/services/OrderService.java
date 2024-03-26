package com.example.springapp1.services;

import com.example.springapp1.model.dto.OrderDto;
import com.example.springapp1.model.web.LensOrderParams;

import java.util.List;

public interface OrderService {

    OrderDto createOrder(String sessionId, List<LensOrderParams> lenses);

    OrderDto getOrder(String orderId);

    List<OrderDto> getOrders(String sessionId);
}
