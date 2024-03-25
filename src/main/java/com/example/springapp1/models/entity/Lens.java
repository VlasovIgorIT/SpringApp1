package com.example.springapp1.models.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@FieldDefaults(level = PRIVATE)
@JsonInclude(value = NON_NULL)
public class Lens {

    String id;
    String name;
    String color;
    String cover;
    String design;
    Double index;
    String filter;
    Integer diameter;
    String diopter;
}