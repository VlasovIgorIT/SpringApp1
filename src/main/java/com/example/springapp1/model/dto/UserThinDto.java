package com.example.springapp1.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Schema(description = "Модель клиента для отображения и создания уникальной сессии")
public class UserThinDto {

    @Schema(description = "ID клиента", example = "125")
    String id;

    @Schema(description = "Имя клиента", example = "Игорь Власов")
    String name;

    @Schema(description = "ID сессии", example = "125659421654687456")
    String sessionId;
}