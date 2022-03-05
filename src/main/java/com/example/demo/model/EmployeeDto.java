package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {

    private String name;
    private String lastname;
    private Integer age;

}
