package com.tranminhthang.SpringBootTutorial.controller;

import com.tranminhthang.SpringBootTutorial.entity.Department;
import com.tranminhthang.SpringBootTutorial.error.DepartmentNotFoundException;
import com.tranminhthang.SpringBootTutorial.service.DepartmentService;
import org.hibernate.boot.model.relational.Loggable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
public class DepartmentController {
    //@Autowired trong spring giup ta thay vi phai tao object bang new keyword thi no se tu dong tao cho ta hehe :))
    @Autowired
    private DepartmentService departmentService;

    //ghi lai log cua Department,mac dinh log se ghi len console nhung neu thich co the dieu chinh
    // cho springboot ghi ra file trong application.properties
    private Logger logger = LoggerFactory.getLogger(Department.class);
    //@RequestBody la lay body tu request cua client(json), chuyen no thanh dang Department(Ep kieu ay)
    @PostMapping(value = "/department")
    //@PostMapping = @RequestMapping(value = "/", method = RequestMethod.POST)
    //@Valid la annotion de kiem tra voi dieu kien o Department Class(NotBlank)
    public Department saveDepartment(@Valid @RequestBody Department department){
        //truyen tu Controller->Service->Repository
        logger.info("Save Department");
        return departmentService.saveDepartment(department);
    }
    //h la phan lay data tu DB hehe
    @GetMapping("/department")
    public List<Department> fetchDepartment(){
        return departmentService.fetchDepartment();
    }
    //lay data tu DB nhung lay theo ID(tuc la lay tung cai 1)
    @GetMapping("/department/{id}")
    //@PathVariable la de lay bien tu path(trong th nay la bien id)
    public  Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }
    //xoa du lieu trong database
    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long deparmentId){
        departmentService.deleteDepartmentById(deparmentId);
        return "Delete Department Complete!!!";
    }
    //update department thi dung put nha
    @PutMapping("department/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId,
                                           @RequestBody Department department){
        return departmentService.updateDepartmentById(departmentId,department);
    }
    //lay du lieu tu database theo ten'
    @GetMapping("/department/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
