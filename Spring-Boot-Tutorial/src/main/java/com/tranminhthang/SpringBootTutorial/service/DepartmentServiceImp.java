package com.tranminhthang.SpringBootTutorial.service;

import com.tranminhthang.SpringBootTutorial.entity.Department;
import com.tranminhthang.SpringBootTutorial.error.DepartmentNotFoundException;
import com.tranminhthang.SpringBootTutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements  DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    //nhap data len DB
    @Override
    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }
    //lay data tu DB
    @Override
    public List<Department> fetchDepartment() {
        return departmentRepository.findAll();
    }
    //lay data tu DB theo ID
    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> finding = departmentRepository.findById(departmentId);
        String message = "Department is not avaiable!";
        //dong if nghia la neu k co se chay qua exception
        if(!finding.isPresent()){
            throw new DepartmentNotFoundException(message);
        }
        return finding.get();
    }
    //delete du lieu tu database
    @Override
    public void deleteDepartmentById(Long deparmentId) {
        departmentRepository.deleteById(deparmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId,Department department) {
        Department updateDepartment = departmentRepository.findById(departmentId).get();
        //kiem tra ten khong duoc null va khong duoc la rong
        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())){
            updateDepartment.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            updateDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            updateDepartment.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(updateDepartment);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
//        departmentRepository khong co method tu dong cho viec tim kiem theo ten nen ta phai tu implement
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
