package com.sample.micro.departmentservice.service;

import com.sample.micro.departmentservice.dto.DepartmentDto;

import java.util.List;

/**
 * The interface Department service.
 */
public interface DepartmentService {
    /**
     * Gets department.
     *
     * @param departmentId the department id
     * @return the department
     */
    DepartmentDto getDepartment(Long departmentId);

    /**
     * Gets departments.
     *
     * @return the departments
     */
    List<DepartmentDto> getDepartments();

    /**
     * Save department department dto.
     *
     * @param departmentDto the department dto
     * @return the department dto
     */
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    /**
     * Update department department dto.
     *
     * @param departmentDto the department dto
     * @param departmentId  the department id
     * @return the department dto
     */
    DepartmentDto updateDepartment(DepartmentDto departmentDto, Long departmentId);

    /**
     * Delete department long.
     *
     * @param departmentId the department id
     * @return the long
     */
    Long deleteDepartment(Long departmentId);
}
