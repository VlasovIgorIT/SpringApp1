package com.example.springapp1.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@FieldDefaults(level = PRIVATE)
public class User {

    String id;
    String name;
    String address;
    String phone;
    String email;
    String INN;
    String password;
}
