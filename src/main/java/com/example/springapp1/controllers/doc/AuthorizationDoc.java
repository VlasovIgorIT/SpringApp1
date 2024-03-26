package com.example.springapp1.controllers.doc;

import com.example.springapp1.model.dto.UserThinDto;
import com.example.springapp1.model.web.LoginParams;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "auth-controller", description = "Контроллер для аутентификации и авторизации")
public interface AuthorizationDoc {

    @Operation(summary = "Аутентификация клиента",
            description = "Аутентификация с помощью логина и пароля")
    @ApiResponse(responseCode = "200", description = "Клиент найден, сессия создана",
            content = @Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = UserThinDto.class)))
    @ApiResponse(responseCode = "404", description = "Неверные логин или пароль",
            content = @Content(schema = @Schema()))
    ResponseEntity<?> login(@Parameter LoginParams loginParams,
                            BindingResult bindingResult);
}