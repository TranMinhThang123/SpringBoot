package com.tranminhthang.SpringBootTutorial.configEnpoint;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Component
@Endpoint(id="features")//chi ra day la endpoint co id la features tuc la link truy cap se la http://localhost:8082/actuator/features
public class FeaturesEndpoint {
    //Endpoint thuc ra la cai link thoi ,no tuong tu API :)),xam vcl
    private final Map<String, ArrayList<String>> featureMap =
            new ConcurrentHashMap<>();

    //@ReadOperation chi ra rang day la ham doc va tra ve gia tri nao do
    //trong TH nay la 1 list cac features
    @ReadOperation
    public Map<String,ArrayList<String>> features(){
        return featureMap;
    }
    //Ngoai @ReadOperation ra con co
    //+@WriteOperation
    //+@DeleteOperation
    @ReadOperation
    public ArrayList<String> feature(@Selector String featureName){
        //@Selector chi ra rang bien dau vao featureName phai duoc chon tu user
        return featureMap.get(featureName);
    }
    //Tao data cho featuresMap de co cai ma tra ve chu
    public FeaturesEndpoint(){
        ArrayList<String> departmentFeature = new ArrayList<String>();
        departmentFeature.add("This is department feature");
        departmentFeature.add("It contains three departments:IT,HR,Marketing");
        ArrayList<String> UserFeaturers = new ArrayList<String>();
        UserFeaturers.add("This is User feature");
        UserFeaturers.add("It contains name,age,address of user");
        ArrayList<String> Authentication = new ArrayList<String>();
        Authentication.add("This is Authenticaiton info");
        Authentication.add("It contain username,password and hash password of user");
        featureMap.put("Department",departmentFeature);
        featureMap.put("User",UserFeaturers);
        featureMap.put("Authentication",Authentication);
    }
}
