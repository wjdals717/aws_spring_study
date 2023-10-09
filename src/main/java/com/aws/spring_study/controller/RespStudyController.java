package com.aws.spring_study.controller;

import com.aws.spring_study.dto.JsonTestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RespStudyController {
    @GetMapping("resp/str")
    public String strTest() {
        return "문자열";
    }

    @GetMapping("resp/obj")
    public Object objectTest() {
        Map<String, Object> responseMap = new HashMap<>();
        return responseMap;     //Object(반환형)에 Map을 사용하면 자동으로 JSON으로 응답
    }

    @GetMapping("resp/obj2")
    public Object objectTest2() {
        JsonTestDto jsonTestDto = new JsonTestDto();
        jsonTestDto.setName("변정민");
        jsonTestDto.setAge(22);
        return jsonTestDto;
    }

    @GetMapping("resp/status")
    public Object statusTest2(HttpServletResponse response) {   //서블릿에서 사용하던 요청/응답 데이터를 가져올 수 있음
        response.setStatus(400);
        return null;
    }

    @GetMapping("/resp/resp-entity")
    public ResponseEntity<?> responseEntityTest() {
        JsonTestDto jsonTestDto = new JsonTestDto();
        jsonTestDto.setName("변정민");
        jsonTestDto.setAge(22);
        return new ResponseEntity<>(jsonTestDto, HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/resp/map-resp-entity")
    public ResponseEntity<Map<String, Object>> mapresponseENtity() {
        Map<String, Object> map = new HashMap<>();
        map.put("data","데이터입니다.");
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @GetMapping("/resp")
    public ResponseEntity<JsonTestDto> jsonResponse() {
        JsonTestDto jsonTestDto = new JsonTestDto();
        jsonTestDto.setName("변정민");
        jsonTestDto.setAge(22);
//        return ResponseEntity.ok().body(jsonTestDto);
//        return ResponseEntity.badRequest().body(jsonTestDto);
//        return ResponseEntity.status(405).body(jsonTestDto);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonTestDto);
    }





}
