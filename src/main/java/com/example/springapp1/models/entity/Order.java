package com.example.springapp1.models.entity;

import com.example.springapp1.models.enums.OrderStatus;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class Order {

    String id;

    Map<String, Integer> quantityByLensIdMap;

    LocalDateTime orderDate;

    OrderStatus status;
}
