package com.sample.micro.departmentservice.service;

import com.sample.micro.departmentservice.converters.DepartmentConverter;
import com.sample.micro.departmentservice.dto.DepartmentDto;
import com.sample.micro.departmentservice.entity.Department;
import com.sample.micro.departmentservice.exception.EmptyInputException;
import com.sample.micro.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Department service.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentConverter departmentConverter;

    @Override
    public DepartmentDto getDepartment(Long departmentId) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (!optionalDepartment.isPresent()) {

            throw new EmptyInputException("601", "Empty input exception");
        }
        return departmentConverter.toDto(optionalDepartment.get());
    }

    @Override
    public List<DepartmentDto> getDepartments() {
        return departmentRepository.findAll().stream().map(department -> departmentConverter.toDto(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        return departmentConverter.toDto(departmentRepository.save(departmentConverter.toEntity(departmentDto)));
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentDto.getDepartmentId());
        if (!optionalDepartment.isPresent()) {
            throw new EmptyInputException("601", "Empty input exception");
        }
        return saveDepartment(departmentDto);
    }

    @Override
    public Long deleteDepartment(Long departmentId) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (!optionalDepartment.isPresent()) {
            throw new EmptyInputException("601", "Empty input exception");
        }
        departmentRepository.delete(optionalDepartment.get());
        return departmentId;
    }
}
