package com.tranminhthang.SpringBootTutorial.service;

import com.tranminhthang.SpringBootTutorial.entity.Department;
import com.tranminhthang.SpringBootTutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    //nhap data len DB
    public Department saveDepartment(Department department);
    //lay data tu DB
    public List<Department> fetchDepartment();
    //lay data tu DB nhung theo id
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;
    //delete du lieu trong database
    public void deleteDepartmentById(Long deparmentId);
    //update du lieu trong database
    public Department updateDepartmentById(Long departmentId,Department department);
    //lay du lieu theo ten
    public Department fetchDepartmentByName(String departmentName);
}
