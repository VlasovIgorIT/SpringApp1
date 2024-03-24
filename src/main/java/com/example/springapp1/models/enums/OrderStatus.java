package com.example.springapp1.models.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {

    REGISTERED("Зарегистрирован"),
    IN_PROGRESS("В работе"),
    COMPLETED("Выполнен");

    final String description;

    OrderStatus(String description) {
        this.description = description;
    }
}
