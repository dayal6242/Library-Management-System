package com.example.library.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.library.service.DepartmentService;

@SpringBootTest
public class DepartmentTest {

	 @Autowired
	    private DepartmentService departmentService;

	    @Test
	    public void testAddDepartment() {
	        Department department = new Department();
	        department.setName("Test Department");

	        Department savedDepartment = departmentService.addDepartment(department);

	        assertNotNull(savedDepartment.getId());
	        assertEquals("Test Department", savedDepartment.getName());
	    }

	    
}
