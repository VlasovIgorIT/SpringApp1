package com.example.springapp1.models.entity;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class Lens {

    String id;
    String name;
    String color;
    String cover;
    String design;
    float index;
    String filter;
    int diameter;
    String diopter;



}
