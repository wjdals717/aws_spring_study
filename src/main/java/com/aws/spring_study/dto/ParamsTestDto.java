package com.aws.spring_study.dto;

import lombok.Data;

@Data   //setter가 있어야 데이터 값을 받아들임
public class ParamsTestDto {
    private String name;
    private Integer age;
}
