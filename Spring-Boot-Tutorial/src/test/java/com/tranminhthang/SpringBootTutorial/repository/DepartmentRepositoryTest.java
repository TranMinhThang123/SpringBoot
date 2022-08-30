package com.tranminhthang.SpringBootTutorial.repository;

import com.tranminhthang.SpringBootTutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
//note : test repository layer can de annotion la @DataJpaTest
@DataJpaTest
class DepartmentRepositoryTest {

    //tao ra doi tuong cua class can test
    @Autowired
    private DepartmentRepository departmentRepository;

    //tao ra database ao
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        //tao ra doi tuong can luu trong database
        Department department = Department.builder()
                .departmentCode("CE-01")
                .departmentName("CE")
                .departmentAddress("Hoan Kiem, Ha Noi")
                .build();
        //luu vao trong database
        entityManager.persist(department);
    }
    @Test
    @DisplayName("Test Repository layer")
    public void whenDepartmentRepository_thenReturn(){
        Department found = departmentRepository.findById(1L).get();
        //so sanh neu ten cua departmentfount=CE-01 thi testcase pass
        assertEquals(found.getDepartmentCode(),"CE-01");
    }
}