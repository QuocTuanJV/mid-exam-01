package com.tuanlq.midexam.repositories;

import com.tuanlq.midexam.model.Department;
import com.tuanlq.midexam.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Pageable;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    Iterable<Employee> findAllByDepartment(Department department);
    Page<Employee> findAllByNameContaining(String name, Pageable pageable);
}
