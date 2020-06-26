package com.catzhang.restfulcrud.service;

import com.catzhang.restfulcrud.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> find();

    public Employee getEmployeeByID(Integer id);

    public void saveEmployee(Employee employee);

    public void insertEmployee(Employee employee);

    public void deleteEmployee(Integer id);
}
