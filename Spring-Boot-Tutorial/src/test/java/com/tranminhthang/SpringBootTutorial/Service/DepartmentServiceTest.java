package com.tranminhthang.SpringBootTutorial.Service;

import com.tranminhthang.SpringBootTutorial.entity.Department;
import com.tranminhthang.SpringBootTutorial.repository.DepartmentRepository;
import com.tranminhthang.SpringBootTutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {

    //B1: tao object cua layer can test
    @Autowired
    private DepartmentService departmentService;

    //B2: tao bean cua layer sau
    //ban chat cua spring test la test cac layer 1 cach doc lap,thay vi goi ca 3 layer ra de test,ta chi can chay 1 layer(trong TH nay la Service)
    //vi vay nen ta can gia lap layer Repository de co the chay doc lap duoc va @MockBean la de huong dan testcase thay vi chay den class
    //Repository that thi hay chay den day
    @MockBean
    private DepartmentRepository departmentRepository;


    //@BeforeEach chi ra rang truoc khi 1 test case duoc goi thi ham setUp nay se duoc goi,tuc la no chay truoc 1 testcase
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentId(20L)
                .departmentName("IT")
                .departmentAddress("Hoan Kiem, Ha Noi")
                .departmentCode("IT-06")
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }


    //@Test chi ra rang day la 1 test case
    @Test
    //@DisplayName(<name>) de dat ten cho test case
    @DisplayName("Test Service layer")
    //dung @Disabled de disable testcase nay
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}