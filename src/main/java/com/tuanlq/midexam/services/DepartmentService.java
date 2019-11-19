package com.tuanlq.midexam.services;

import com.tuanlq.midexam.model.Department;

public interface DepartmentService {
    Iterable<Department> findAll();
    Department findById(Long id);
    void save(Department department);
    void remove(Long id);
}
