package com.tranminhthang.SpringBootTutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
//@Entity chi ra rang day la 1 table trong database,no cung duoc tinh la 1 Component
//@Data :no code thay chung ta toan bo phan constructor,settet,getter,toString nen ta k can tu tay code nua
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Builder cho phep chung ta tao ra object nhanh hon thay vi su dung seter hay constructor nhu moi khi,ta se ung dung no trong phan testing
public class Department {
    //2 dong duoi chi ra rang id se duoc cap phat tu dong
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    //@NotBlank chi ra rang ten khong duoc de trong va khi de ten trong se bao loi, message la tin nhan neu loi xay ra
    @NotBlank(message = "Department Name is not blank")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

//    public Long getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(Long departmentId) {
//        this.departmentId = departmentId;
//    }
//
//    public String getDepartmentName() {
//        return departmentName;
//    }
//
//    public void setDepartmentName(String departmentName) {
//        this.departmentName = departmentName;
//    }
//
//    public String getDepartmentAddress() {
//        return departmentAddress;
//    }
//
//    public void setDepartmentAddress(String departmentAddress) {
//        this.departmentAddress = departmentAddress;
//    }
//
//    public String getDepartmentCode() {
//        return departmentCode;
//    }
//
//    public void setDepartmentCode(String departmentCode) {
//        this.departmentCode = departmentCode;
//    }
//
//    public Department(Long departmentId,String departmentName,String departmentAddress,String departmentCode){
//      this.departmentId = departmentId;
//      this.departmentName = departmentName;
//      this.departmentAddress = departmentAddress;
//      this.departmentCode = departmentCode;
//    }
//    public Department(){
//
//    }
//
//    @Override
//    public String toString() {
//        return "Department{" +
//                "departmentId=" + departmentId +
//                ", departmentName='" + departmentName + '\'' +
//                ", departmentAddress='" + departmentAddress + '\'' +
//                ", departmentCode='" + departmentCode + '\'' +
//                '}';
//    }
}
