package com.aws.spring_study.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ReqStudyController {

    @GetMapping("/test/get")
    public Object get() {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("name", "변정민");
        dataMap.put("email", "aaa@gmail.com");
        return dataMap;
    }

    @PostMapping("/test/post")
    public Object post() {
        return "POST";
    }

    @PutMapping("/test/put")
    public Object put() {
        return "PUT";
    }

    @DeleteMapping("/test/delete")
    public Object delete() {
        return "DELETE";
    }
}
