package com.sample.micro.departmentservice.controller;

import com.sample.micro.departmentservice.dto.DepartmentDto;
import com.sample.micro.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/getDepartment/{departmentId}")
    public DepartmentDto getDepartment(@PathVariable Long departmentId) {
        return departmentService.getDepartment(departmentId);
    }

    @PostMapping("/addDepartment")
    public DepartmentDto addNewDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentService.saveDepartment(departmentDto);
    }

    @PutMapping("/updateDepartment")
    public DepartmentDto updateDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentService.updateDepartment(departmentDto);
    }

    @DeleteMapping("/deleteDepartment/{departmentId}")
    public Long deleteDepartment(@PathVariable Long departmentId){
        return departmentService.deleteDepartment(departmentId);
    }

    @GetMapping("/department/all")
    public List<DepartmentDto> getAllDepartments(){
        return departmentService.getDepartments();
    }

}
