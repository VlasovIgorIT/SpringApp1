package com.example.springapp1.mapper;

import com.example.springapp1.models.dto.LensOrderDto;
import com.example.springapp1.models.entity.Lens;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface LensMapper {

    LensOrderDto toDto(Lens lens);
}