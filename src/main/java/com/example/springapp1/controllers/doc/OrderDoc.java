package com.example.springapp1.controllers.doc;

import com.example.springapp1.model.dto.OrderDto;
import com.example.springapp1.model.web.LensOrderParams;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "order-controller", description = "Контроллер для работы с заказами")
public interface OrderDoc {

    @Operation(summary = "Создать заказ", description = "Создание заказа со списком линз и их количеством")
    @ApiResponse(responseCode = "201", description = "Заказ создан",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = OrderDto.class)))
    @ApiResponse(responseCode = "500", description = "Ошибка при передаче данных в 1C", content = @Content(schema = @Schema()))
    ResponseEntity<OrderDto> createOrder(@Parameter(description = "ID сессии пользователя", example = "12349131984657321")
                                         String sessionId,

                                         @Parameter
                                         @NotEmpty(message = "Выберите линзы для заказа")
                                         List<LensOrderParams> lensOrderParams);

    @Operation(summary = "Получить список заказов", description = "Получить список всех заказов клиента")
    @ApiResponse(responseCode = "200", description = "Список заказов получен",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(type = "array", contains = OrderDto.class)))
    @ApiResponse(responseCode = "500", description = "Ошибка при передаче данных в 1C", content = @Content(schema = @Schema()))
    ResponseEntity<List<OrderDto>> getOrders(@Parameter(description = "ID сессии пользователя", example = "12349131984657321")
                                             String sessionId);

    @Operation(summary = "Получить заказ", description = "Получить модель заказа по ID")
    @ApiResponse(responseCode = "200", description = "Заказ получен",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = OrderDto.class)))
    @ApiResponse(responseCode = "500", description = "Ошибка при передаче данных в 1C", content = @Content(schema = @Schema()))
    ResponseEntity<OrderDto> getById(@Parameter(description = "ID заказа", example = "12")
                                     String id);
}
