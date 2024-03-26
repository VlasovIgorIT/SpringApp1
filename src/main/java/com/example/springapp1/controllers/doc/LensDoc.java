package com.example.springapp1.controllers.doc;

import com.example.springapp1.model.entity.Lens;
import com.example.springapp1.model.web.LensFilterParams;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "lens-controller", description = "Контроллер для работы с линзами")
public interface LensDoc {

    @Operation(summary = "Получить список линз", description = "Можно получить как список всех линз, так и отфильтрованный")
    @ApiResponse(responseCode = "200", description = "Список линз получен",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(type = "array", contains = Lens.class)))
    @ApiResponse(responseCode = "500", description = "Ошибка при передаче данных в 1C", content = @Content(schema = @Schema()))
    ResponseEntity<List<Lens>> getLensesByFilter(@Parameter LensFilterParams lensFilterParams);

    @Operation(summary = "Получить линзу", description = "Получение модели линзы по id")
    @ApiResponse(responseCode = "200", description = "Список линз получен",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Lens.class)))
    @ApiResponse(responseCode = "404", description = "По данному ID не найдено записей в БД", content = @Content(schema = @Schema()))
    @ApiResponse(responseCode = "500", description = "Ошибка при передаче данных в 1C", content = @Content(schema = @Schema()))
    ResponseEntity<Lens> getById (@Parameter(description = "ID линзы", example = "1") String id);
}
