package com.example.springapp1.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Schema(description = "Модель заказанной линзы")
public class LensOrderDto {

    @Schema(description = "ID линзы", example = "1")
    String id;

    @Schema(description = "Название линзы", example = "Moonlight")
    String name;

    @Schema(description = "Количество заказанных линз", example = "2")
    Integer quantity;
}
