package com.example.springapp1.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static lombok.AccessLevel.PRIVATE;

@Data
@JsonInclude(NON_NULL)
@FieldDefaults(level = PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Модель для отображения информации о пользователе")
public class UserDto extends UserThinDto{

    @Schema(description = "Адрес клиента", example = "г.Москва, пр. Вернадского 79")
    String address;

    @Schema(description = "Контактный номер клиента", example = "+79991234567")
    String phone;

    @Schema(description = "Email клиента", example = "vlasov@mail.com")
    String email;

    @Schema(description = "ИНН клиента", example = "1232454623198")
    int INN;
}
