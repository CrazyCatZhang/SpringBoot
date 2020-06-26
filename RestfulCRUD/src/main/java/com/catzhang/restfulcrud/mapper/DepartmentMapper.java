package com.catzhang.restfulcrud.mapper;

import com.catzhang.restfulcrud.pojo.Department;
import com.catzhang.restfulcrud.pojo.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
//@Repository
public interface DepartmentMapper {

    @Select("select * from department;")
    public List<Department> find();

    @Select("select * from department where departmentId=#{casual};")
    public Department getDepartmentByID(Integer id);

    @Update("update department set departmentName=#{departmentName} where departmentId=#{id}")
    public void saveDepartment(Department department);

    @Insert("insert into department(departmentName)values(#{departmentName})")
    public void insertDepartment(Department department);

    @Select("delete from department where departmentId = #{id}")
    public void deleteDepartment(Integer id);
}
