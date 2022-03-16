package com.sample.micro.departmentservice.rest;

import com.sample.micro.departmentservice.dto.DepartmentDto;
import com.sample.micro.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Department controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    /**
     * Find department response entity.
     *
     * @param departmentId the department id
     * @return the response entity
     */
    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDto> findDepartment(@PathVariable final Long departmentId) {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getDepartment(departmentId));
    }

    /**
     * Find all departments response entity.
     *
     * @return the response entity
     */
    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDto>> findAllDepartments() {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getDepartments());
    }

    /**
     * Add new department response entity.
     *
     * @param departmentDto the department dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<DepartmentDto> addNewDepartment(@RequestBody final DepartmentDto departmentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.saveDepartment(departmentDto));
    }

    /**
     * Update department response entity.
     *
     * @param departmentDto the department dto
     * @param departmentId  the department id
     * @return the response entity
     */
    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody final DepartmentDto departmentDto, @PathVariable final Long departmentId) {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.updateDepartment(departmentDto, departmentId));
    }

    /**
     * Delete department response entity.
     *
     * @param departmentId the department id
     * @return the response entity
     */
    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Long> deleteDepartment(@PathVariable final Long departmentId) {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.deleteDepartment(departmentId));
    }
}
