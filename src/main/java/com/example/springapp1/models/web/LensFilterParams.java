package com.example.springapp1.models.web;

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

    @Schema(description = "", example = "")
    String name;

    @Schema(description = "", example = "")
    String color;

    @Schema(description = "", example = "")
    String cover;

    @Schema(description = "", example = "")
    String design;

    @Schema(description = "", example = "")
    Double index;

    @Schema(description = "", example = "")
    String filter;

    @Schema(description = "", example = "")
    Integer diameter;

    @Schema(description = "", example = "")
    String diopter;
}
