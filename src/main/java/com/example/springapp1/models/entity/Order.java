package com.example.springapp1.models.entity;

import com.example.springapp1.models.enums.OrderStatus;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@FieldDefaults(level = PRIVATE)
public class Order {

    String id;

    OrderStatus status;

    LocalDateTime orderDate;

    Map<String, Integer> quantityByLensIdMap;
}
