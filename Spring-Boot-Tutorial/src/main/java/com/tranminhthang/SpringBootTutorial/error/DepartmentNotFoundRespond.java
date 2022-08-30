package com.tranminhthang.SpringBootTutorial.error;

import com.tranminhthang.SpringBootTutorial.entity.ErrosMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//class nay se respond neu exception xay ra
//@ControllerAdvice nghia la controller nay se duoc sd neu xay ra exception o 1 package nhat dinh,khong thi no se de o
//dang default tuc la all package
//Duoi day la cu phap neu muon chi dinh package
//@ControllerAdvice(basePackages = "")
@ControllerAdvice
//Tra ve responseStatus
@ResponseStatus
public class DepartmentNotFoundRespond extends ResponseEntityExceptionHandler {
    //method nay tra ve 1 Response voi kieu ErrorMessage(ta se dinh nghia trong phan entity )
    @ExceptionHandler(DepartmentNotFoundException.class)
    //@ExceptionHandler chi ra rang day la exception cua class DepartmentNotFoundException
    //chung ta co the chi ra nhieu exception cua nhieu class hon neu muon
    public ResponseEntity<ErrosMessage> departmentNotFound(DepartmentNotFoundException departmentException){
        ErrosMessage  errosMessage = new ErrosMessage(HttpStatus.NOT_FOUND,departmentException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errosMessage);
    }
}
