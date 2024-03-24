package com.example.springapp1.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Schema(description = "")
public class LensOrderDto {

    @Schema(description = "", example = "")
    String id;

    @Schema(description = "", example = "")
    String name;

    @Schema(description = "", example = "")
    Integer quantity;
}
