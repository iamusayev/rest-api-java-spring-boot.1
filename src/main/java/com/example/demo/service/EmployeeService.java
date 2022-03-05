package com.example.demo.service;


import com.example.demo.dao.entity.EmployeeEntity;
import com.example.demo.dao.repository.EmployeeRepository;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.mapper.EmployeeMapper.*;
import static com.example.demo.mapper.EmployeeMapper.mapDtoToEntity;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public void createEmployee(EmployeeDto employeeDto) {
        repository.save(mapDtoToEntity(employeeDto));
    }

    public EmployeeDto getEmployee(Long id) {
        EmployeeEntity entity = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        EmployeeDto dto = mapEntityToDto(entity);
        return dto;
    }

    public List<EmployeeDto> getEmployees() {
        List<EmployeeEntity> entities = (List) repository.findAll();
        return mapEntitiesToDtos(entities);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    public void updateEmployee(Long id, EmployeeDto dto) {
        EmployeeEntity entity = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        entity.setName(dto.getName());
        entity.setLastname(dto.getLastname());
        entity.setAge(dto.getAge());
        repository.save(entity);
    }

    public void updateEmployeeName(Long id, String name) {
        EmployeeEntity entity = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        entity.setName(name);
        repository.save(entity);
    }

    public void updateEmployeeLastname(Long id, String lastname) {
        EmployeeEntity entity = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        entity.setLastname(lastname);
        repository.save(entity);
    }

    public void updateEmployeeAge(Long id, Integer age) {
        EmployeeEntity entity = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        entity.setAge(age);
        repository.save(entity);
    }

}
