package com.example.springapp1.mapper;

import com.example.springapp1.model.dto.UserDto;
import com.example.springapp1.model.dto.UserThinDto;
import com.example.springapp1.model.entity.User;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE)
public interface UserMapper {

    UserThinDto toThinDto(User user);

    UserDto toDto (User user);
}
