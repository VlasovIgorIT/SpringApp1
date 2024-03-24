package com.example.springapp1.mapper;

import com.example.springapp1.models.dto.LensOrderDto;
import com.example.springapp1.models.entity.Lens;
import com.example.springapp1.models.web.LensFilterParams;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface LensMapper {

    Lens toLens(LensFilterParams params);

    List<Lens> toLensList(List<Lens> paramsList);

    LensOrderDto toDto(Lens lens);
}
