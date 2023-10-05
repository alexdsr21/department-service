package com.sample.micro.departmentservice.converters;

import com.sample.micro.departmentservice.dto.DepartmentDto;
import com.sample.micro.departmentservice.entity.Department;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter {

    public Department toEntity(final DepartmentDto departmentDto) {
        return Department
                .builder()
                .departmentId(departmentDto.getDepartmentId())
                .departmentCode(departmentDto.getDepartmentCode())
                .departmentName(departmentDto.getDepartmentName())
                .departmentAddress(departmentDto.getDepartmentAddress())
                .build();
    }

    public DepartmentDto toDto(final Department department) {
        return DepartmentDto
                .builder()
                .departmentId(department.getDepartmentId())
                .departmentAddress(department.getDepartmentAddress())
                .departmentCode(department.getDepartmentCode())
                .departmentName(department.getDepartmentName())
                .build();
    }

}
