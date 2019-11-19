package com.tuanlq.midexam.repositories;

import com.tuanlq.midexam.model.Department;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DepartmentRepository extends PagingAndSortingRepository<Department,Long> {
}
