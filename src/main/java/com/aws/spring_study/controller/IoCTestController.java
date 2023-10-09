package com.aws.spring_study.controller;

import com.aws.spring_study.service.IocTestService1;
import com.aws.spring_study.service.IocTestService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* Component의 종류
* 1. 요청과 응답 -> @Controller(SSR) -> RESTFUL한 Controller -> @RestController
* 2. 비즈니스 로직(Controller와 Repository(DB) 사이에서 처리되는 로직 ) -> @Service
* 3. 데이터베이스 -> @Repository -> DAO -> Mybatis(@Mapper)
* 4. 설정, 2개 이상의 Bean 등록 -> @Configuration
* 5. 그 외의 모든 IoC 객체는 @Component를 사용!!!
*/

@RestController
public class IoCTestController {
    @Autowired      //IoC에서 해당하는 거 찾아서 넣어줌
    private IocTestService1 iocTestService1;
    @Autowired
    private IocTestService2 iocTestService2;

//    public IoCTestController() {
//        iocTestService1  = new IocTestService1();
//        iocTestService2 = new IocTestService2();
//    }

    @GetMapping("ioc/test")
    public ResponseEntity testGet() {
        iocTestService1.t1();
        iocTestService2.t2();
        return ResponseEntity.ok(null);
    }
}
