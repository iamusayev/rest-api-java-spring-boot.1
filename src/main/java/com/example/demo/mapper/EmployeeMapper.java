package com.example.demo.mapper;

import com.example.demo.dao.entity.EmployeeEntity;
import com.example.demo.model.EmployeeDto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {

    public static EmployeeEntity mapDtoToEntity(EmployeeDto dto) {
        return EmployeeEntity.builder()
                .name(dto.getName())
                .lastname(dto.getLastname())
                .age(dto.getAge())
                .build();
    }

    public static EmployeeDto mapEntityToDto(EmployeeEntity entity) {
        return EmployeeDto.builder()
                .name(entity.getName())
                .lastname(entity.getLastname())
                .age(entity.getAge())
                .build();
    }

    public static List<EmployeeDto> mapEntitiesToDtos(List<EmployeeEntity> entities) {
        List<EmployeeDto> dtos = new ArrayList<>();
        for (EmployeeEntity entity : entities) {
            dtos.add(mapEntityToDto(entity));
        }
        return dtos;
    }

}
