package com.example.demo.controller;


import com.example.demo.model.EmployeeDto;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody EmployeeDto dto) {
        service.createEmployee(dto);
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id) {
        return service.getEmployee(id);
    }

    @GetMapping
    public List<EmployeeDto> getEmployees() {
        return service.getEmployees();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
    }

    @PutMapping("/{id}")
    private void updateEmployee(@PathVariable Long id,
                                @RequestBody EmployeeDto dto) {
        service.updateEmployee(id, dto);
    }

    @PatchMapping("/{id}/name")
    public void updateEmployeeName(@PathVariable Long id,
                                   @RequestParam(value = "value") String name) {
        service.updateEmployeeName(id, name);
    }

    @PatchMapping("/{id}/lastname")
    public void updateEmployeeLastname(@PathVariable Long id,
                                       @RequestParam(value = "value") String lastname) {
        service.updateEmployeeLastname(id, lastname);
    }

    @PatchMapping("/{id}/age")
    public void updateEmployeeAge(@PathVariable Long id,
                                  @RequestParam(value = "value") Integer age) {
        service.updateEmployeeAge(id, age);
    }
}
