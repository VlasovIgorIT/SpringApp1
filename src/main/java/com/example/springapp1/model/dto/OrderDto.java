package com.example.springapp1.model.dto;

import com.example.springapp1.model.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static lombok.AccessLevel.PRIVATE;

@Data
@JsonInclude(NON_NULL)
@FieldDefaults(level = PRIVATE)
@Schema(description = "Модель заказа для отображения пользователю")
public class OrderDto {

    @Schema(description = "ID заказа", example = "1")
    String id;

    @Schema(description = "Список моделей линз",
            implementation = LensOrderDto.class)
    List<LensOrderDto> lensList;

    @Schema(type = "string",
            pattern = "dd-MM-yyyy HH:mm:ss",
            example = "29-02-2024 11:49:47",
            description = "Дата оформления заказа")
    @JsonFormat(shape = STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime orderDate;

    @Schema(description = "Статус заказа", anyOf = OrderStatus.class)
    OrderStatus status;
}