package com.example.springapp1.models.web;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Schema(description = "")
public class LoginParams {

    @NotBlank(message = "Email не может быть пустым")
    @Email(message = "Неверный формат email")
    @Schema(description = "", example = "")
    String email;

    @NotBlank(message = "Пароль не может быть пустым")
    @Schema(description = "", example = "")
    String password;
}