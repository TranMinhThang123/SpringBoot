package com.tranminhthang.SpringBootTutorial.controller;

import com.tranminhthang.SpringBootTutorial.entity.Department;
import com.tranminhthang.SpringBootTutorial.error.DepartmentNotFoundException;
import com.tranminhthang.SpringBootTutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {


    //test controller layer thi can MockMvc cung giong nhu repos layer thi can
    //entityManager v,no dung de gia lap request cua chung ta den may chu
    @Autowired
    private MockMvc mockMvc;

    //tat nhien la can mockbean den layer sau r
    @MockBean
    private DepartmentService departmentService;


    //day la department can phai duoc tra ve (doi voi saveDepartment() va fetchDepartmentbyID())
    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentCode("IT")
                .departmentName("IT-06")
                .departmentAddress("Thanh Xuan Ha Noi")
                .departmentId(1L).build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentCode("IT")
                .departmentName("IT-06")
                .departmentAddress("Thanh Xuan Ha Noi")
                .build();

        //khi nao departmentService.saveDepartment(inputDepartment) duoc goi
        //thi tra ve department
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        //gia lap request den may cu :)) va test luon neu testcase dung
        mockMvc.perform(MockMvcRequestBuilders.post("/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\":\"IT-06\",\n" +
                        "\t\"departmentAddress\":\"Thanh Xuan Ha Noi\",\n" +
                        "\t\"departmentCode\":\"IT\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.get("/department/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));

    }
}