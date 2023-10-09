package com.aws.spring_study.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component  //Ioc에 등록됨
@Service
public class IocTestService2 {
    public void t2() {
        System.out.println("테스트 서비스2 호출");
    }
}
