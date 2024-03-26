package com.example.springapp1.model.web;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "Модель для поиска и фильтрации линз по критериям")
public class LensFilterParams {

    @Schema(description = "Название линзы", example = "Moonlight")
    String name;

    @Schema(description = "Цвет", example = "Черная")
    String color;

    @Schema(description = "Покрытие", example = "Матовое")
    String cover;

    @Schema(description = "Дизайн", example = "Утонченный")
    String design;

    @Schema(description = "Индекс", example = "3.25")
    Double index;

    @Schema(description = "Фильтр", example = "Поляризующий")
    String filter;

    @Schema(description = "Диаметр", example = "2")
    Integer diameter;

    @Schema(description = "Диоптер???)))", example = "DIOPTER")
    String diopter;
}
