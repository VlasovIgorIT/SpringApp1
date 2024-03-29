package com.example.springapp1.mapper;

import com.example.springapp1.model.dto.OrderDto;
import com.example.springapp1.model.entity.Order;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING,
        unmappedTargetPolicy = IGNORE,
        uses = LensMapper.class)
public interface OrderMapper {

    OrderDto toDto(Order order);
}
