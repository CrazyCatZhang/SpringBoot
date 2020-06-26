package com.catzhang.restfulcrud.mapper;

import com.catzhang.restfulcrud.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
//@Repository
public interface EmployeeMapper {

    public List<Employee> find();

    public Employee getEmployeeByID(Integer id);

    public void saveEmployee(Employee employee);

    public void insertEmployee(Employee employee);

    public void deleteEmployee(Integer id);
}
