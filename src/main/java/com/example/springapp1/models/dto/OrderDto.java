package com.example.springapp1.models.dto;

import com.example.springapp1.models.enums.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Schema(description = "")
public class OrderDto {

    @Schema(description = "", example = "")
    String id;

    @Schema(description = "", example = "")
    List<LensOrderDto> lensList;

    @Schema(description = "", example = "")
    LocalDateTime orderDate;

    @Schema(description = "", example = "")
    OrderStatus status;
}
