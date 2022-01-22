package com.amirkenesbay.spring.mvc_hibernate_aop.dao;

import com.amirkenesbay.spring.mvc_hibernate_aop.entity.Department;
import com.amirkenesbay.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface DepartmentDAO {
    public List<Department> getAllDepartments();

    public void saveDepartment(Department department);

    public Department getDepartment(int id);

    public void deleteDepartment(int id);
}
