package com.gameloft9.demo.service.impl;

import com.gameloft9.demo.beans.Car;
import com.gameloft9.demo.service.ICarFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

/**
 * 普通校验示例
 * Created by gameloft9 on 2018/8/14.
 */
public class CarFactory implements ICarFactory{


    public String checkCar(Car car) {
        // 拿到validator对象
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // 开始校验
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );

        // 获取校验结果
        if(constraintViolations.isEmpty()){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Iterator it = constraintViolations.iterator();
        while(it.hasNext()){
            ConstraintViolation<Car> cv = (ConstraintViolation<Car>)it.next();
            sb.append(cv.getMessage()).append(";");
        }

        return sb.toString();
    }
}
