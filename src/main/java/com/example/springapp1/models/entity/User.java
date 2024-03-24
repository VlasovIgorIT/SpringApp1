package com.example.springapp1.models.entity;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class User {

    String id;
    String name;
    String address;
    String phone;
    String email;
    int INN;
    String password;
}
