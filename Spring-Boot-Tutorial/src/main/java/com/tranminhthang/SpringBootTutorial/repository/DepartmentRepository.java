package com.tranminhthang.SpringBootTutorial.repository;

import com.tranminhthang.SpringBootTutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//chi ra day la 1 repo(phan code trong day se tuong tac vs database)
//chinh vi day la phan code tuong tac vs database nen ta co 1 interface co san cua spring la
//JpaRepository nen ta se ke thua no hehe
//JpaRepository co nhieu code da viet san de tuong tac vs database
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{
    //du khong co method cho viec tim theo ten nhung no co theo convert tu tim id sang tim ten(ao vl)
    //cu phap findBy+<ten cua thuoc tinh cua entity can tim(nho viet hoa chu cai dau)>
    public Department findByDepartmentName(String departmentName);
    //tuy nhien neu lam theo cu phap tren chi ra duoc dung ten thoi
    //VD ten la Thang nhung neu nhap vao tHaNG hay thang se k check duoc
    //them IgnoreCase vao sau thi moi duoc nhe
    public Department findByDepartmentNameIgnoreCase(String departmentName);
    //doi voi cac thao tac truy van khong co san trong jpa co theo thay the nhu v
    //nhung co 1 so thao tac truy van kho vai noi khong the dua vao cac method co san trong jpa
    //ta phai su dung @Query de khai bao truy van
    //tai lieu o day nhe
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
}
