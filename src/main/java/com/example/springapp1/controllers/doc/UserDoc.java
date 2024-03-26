package com.example.springapp1.controllers.doc;

import com.example.springapp1.model.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "user-controller", description = "Контроллер получения информации о клиенте")
public interface UserDoc {

    @Operation(summary = "Получить модель клиента")
    @ApiResponse(responseCode = "201", description = "Информация получена",
            content = @Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = UserDto.class)))
    ResponseEntity<UserDto> getUserInfo(@Parameter(description = "ID сессии пользователя",
                                                   example = "12349131984657321")
                                        String sessionId);
}
