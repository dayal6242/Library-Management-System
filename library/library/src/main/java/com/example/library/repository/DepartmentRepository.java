package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
