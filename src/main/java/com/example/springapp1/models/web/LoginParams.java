package com.example.springapp1.models.web;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Schema(description = "Модель для аутентификации")
public class LoginParams {

    @NotBlank(message = "Email не может быть пустым")
    @Email(message = "Неверный формат email")
    @Schema(description = "Email клиента", example = "vlasov@mail.com")
    String email;

    @NotBlank(message = "Пароль не может быть пустым")
    @Schema(description = "Пароль клиента", example = "123456789")
    String password;
}