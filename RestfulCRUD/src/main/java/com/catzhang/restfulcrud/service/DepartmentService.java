package com.catzhang.restfulcrud.service;

import com.catzhang.restfulcrud.pojo.Department;

import java.util.List;

public interface DepartmentService {

    public List<Department> find();

    public Department getDepartmentByID(Integer id);

    public void saveDepartment(Department department);

    public void insertDepartment(Department department);

    public void deleteDepartment(Integer id);
}
