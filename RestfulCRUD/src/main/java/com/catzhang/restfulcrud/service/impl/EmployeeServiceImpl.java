package com.catzhang.restfulcrud.service.impl;

import com.catzhang.restfulcrud.mapper.EmployeeMapper;
import com.catzhang.restfulcrud.pojo.Employee;
import com.catzhang.restfulcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<Employee> find() {
        return this.employeeMapper.find();
    }

    @Override
    public Employee getEmployeeByID(Integer id) {
        return this.employeeMapper.getEmployeeByID(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeMapper.saveEmployee(employee);
    }

    @Override
    public void insertEmployee(Employee employee) {
        this.employeeMapper.insertEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        this.employeeMapper.deleteEmployee(id);
    }
}
