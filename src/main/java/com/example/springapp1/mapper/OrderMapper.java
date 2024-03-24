package com.example.springapp1.mapper;

import com.example.springapp1.models.dto.OrderDto;
import com.example.springapp1.models.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING,
        unmappedTargetPolicy = IGNORE,
        uses = LensMapper.class)
public interface OrderMapper {

    OrderDto toDto(Order order);

    List<OrderDto> toDtoList(List<Order> orders);
}
