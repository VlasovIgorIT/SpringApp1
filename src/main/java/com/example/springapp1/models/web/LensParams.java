package com.example.springapp1.models.web;

import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class LensParams {
    String name;
    String color;
    String cover;
    String design;
    float index;
    String filter;
    int diameter;
    String diopter;
}
