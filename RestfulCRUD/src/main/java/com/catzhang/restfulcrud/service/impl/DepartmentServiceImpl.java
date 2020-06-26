package com.catzhang.restfulcrud.service.impl;

import com.catzhang.restfulcrud.mapper.DepartmentMapper;
import com.catzhang.restfulcrud.pojo.Department;
import com.catzhang.restfulcrud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public List<Department> find() {
        return this.departmentMapper.find();
    }

    @Override
    public Department getDepartmentByID(Integer id) {
        return this.departmentMapper.getDepartmentByID(id);
    }

    @Override
    public void saveDepartment(Department department) {
        this.departmentMapper.saveDepartment(department);
    }

    @Override
    public void insertDepartment(Department department) {
        this.departmentMapper.insertDepartment(department);
    }

    @Override
    public void deleteDepartment(Integer id) {
        this.departmentMapper.deleteDepartment(id);
    }
}
