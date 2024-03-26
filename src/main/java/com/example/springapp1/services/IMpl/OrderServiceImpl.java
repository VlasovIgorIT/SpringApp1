package com.example.springapp1.services.IMpl;

import com.example.springapp1.client.LensClient;
import com.example.springapp1.client.OrderClient;
import com.example.springapp1.client.UserClient;
import com.example.springapp1.mapper.LensMapper;
import com.example.springapp1.mapper.OrderMapper;
import com.example.springapp1.model.dto.LensOrderDto;
import com.example.springapp1.model.dto.OrderDto;
import com.example.springapp1.model.entity.Lens;
import com.example.springapp1.model.entity.Order;
import com.example.springapp1.model.web.LensOrderParams;
import com.example.springapp1.services.OrderService;
import com.example.springapp1.services.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

import static java.util.List.of;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class OrderServiceImpl implements OrderService {

    SessionService sessionService;
    OrderMapper orderMapper;
    OrderClient orderClient;
    UserClient userClient;
    LensClient lensClient;
    LensMapper lensMapper;

    @Override
    public OrderDto createOrder(String sessionId, List<LensOrderParams> lenses) {
        val userId = sessionService.getUserFromSession(sessionId).getId();
        return orderClient.createOrder(userId, lenses)
                .map(order -> processDtoList(of(order)).getFirst())
                .orElseThrow(() -> new ResponseStatusException(INTERNAL_SERVER_ERROR,
                        "Не удалось совершить заказ. Обратитесь к администратору"));
    }

    @Override
    public OrderDto getOrder(String orderId) {
        return orderClient.getOrder(orderId)
                .map(order -> processDtoList(of(order)).getFirst())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Заказ не найден"));
    }

    @Override
    public List<OrderDto> getOrders(String sessionId) {
        val userId = sessionService.getUserFromSession(sessionId).getId();
        List<Order> orders = userClient.getOrderList(userId);

        return processDtoList(orders);
    }

    //Из Map<String, Integer> quantityByLensIdMap мы получаем List<LensOrderDto> lensList
    private List<OrderDto> processDtoList(List<Order> orders) {
        List<String> lensIds = orders.stream()
                .flatMap(order -> order.getQuantityByLensIdMap().keySet().stream()).toList();

        Map<String, Lens> lensByIdMap = lensClient.getByIdList(lensIds).stream()
                .collect(toMap(Lens::getId, identity()));

        return orders.stream()
                .map(order -> {
                    val orderDto = orderMapper.toDto(order);
                    List<LensOrderDto> lensDtoList = order.getQuantityByLensIdMap().keySet().stream()
                            .map(lensId -> {
                                val lensDto = lensMapper.toDto(lensByIdMap.get(lensId));
                                lensDto.setQuantity(order.getQuantityByLensIdMap().get(lensId));
                                return lensDto;
                            }).toList();
                    orderDto.setLensList(lensDtoList);
                    return orderDto;
                }).toList();
    }
}
