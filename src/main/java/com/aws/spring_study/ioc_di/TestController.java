package com.aws.spring_study.ioc_di;

public class TestController {
    private TestService t;

    public TestController(TestService t) {
        //t = new TestService1();     //호출될 때(생성자에서) 생성되는 것은 결합도가 높음!
        this.t = t;                   //외부에서 의존성이 전달되고 있으므로 의존성이 낮음!
    }

    public void control() {
        t.aaa();
    }
}
