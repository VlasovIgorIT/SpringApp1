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
@Schema()
public class UserDto extends UserThinDto{

    @Schema(description = "", example = "")
    String address;

    @Schema(description = "", example = "")
    String phone;

    @Schema(description = "", example = "")
    String email;

    @Schema(description = "", example = "")
    int INN;

    @Schema(description = "", example = "")
    String password;
}
