package com.tranminhthang.SpringBootTutorial.error;

import org.springframework.stereotype.Component;

@Component
public class DepartmentNotFoundException extends Exception{

    public DepartmentNotFoundException() {
        super();
    }
    public DepartmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundException(String message) {
        super(message);
    }

    public DepartmentNotFoundException(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
