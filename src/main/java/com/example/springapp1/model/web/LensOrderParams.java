package com.example.springapp1.model.web;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Schema(description = "Модель для заказа линз(ы)")
public class LensOrderParams {

    @Schema(description = "Id линзы", example = "1")
    @NotBlank(message = "Выберите линзу")
    String id;

    @Schema(description = "Количество", example = "2")
    @NotNull(message = "Укажите количество")
    Integer quantity;
}