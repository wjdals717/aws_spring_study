package com.aws.spring_study.controller;

import com.aws.spring_study.dto.ModifyUserReqDto;
import com.aws.spring_study.dto.RegisterUserReqDto;
import com.aws.spring_study.entity.User;
import com.aws.spring_study.repository.UserMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController     // 컴포넌트가 되어 ioc에 등록이 됨, 컨트롤러 기능도 하기 때문에 @RestController 사용
@RequiredArgsConstructor
public class UsersController {
//    @Autowired    //자동으로 객체 생성해서 연결 UsersController <->user_mapper.xml 연결해줌
//    @Qualifier("service1")

    private final UserMappers userMappers;      //final 상수가 되면 무조건 매개변수로 들어와야 함! -> @RequiredArgsConstructor가 찾는 역할

    @CrossOrigin                //서로 다른 서버의 통신을 위함
    @PostMapping("/user")       //user를 등록하는 것
    public ResponseEntity<Integer> registerUser(@RequestBody RegisterUserReqDto registerUserReqDto) { //JSON -> RegisterUserReqDto타입으로 자동 변경
        Integer count = userMappers.saveUser(registerUserReqDto);   //Dto는 client가 준 데이터
        return ResponseEntity.ok().body(count);                     //그 데이터를 UserMappers.xml한테 넘겨줌
    }

    @CrossOrigin
    @GetMapping("/user/list")
    public ResponseEntity<List<User>> userListAll() {
        return ResponseEntity.ok().body(userMappers.getUserListAll());      //list return 해 줌
    }

    @CrossOrigin
    @PutMapping("/users/{userId}")
    public ResponseEntity<Integer> modifyUser(@PathVariable int userId, @RequestBody ModifyUserReqDto modifyUserReqDto) {
        Integer count = userMappers.updateUser(modifyUserReqDto);
        return ResponseEntity.ok().body(count);
    }

    @CrossOrigin
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Integer> deleteUser(@PathVariable int userId) {
        Integer count = userMappers.deleteUser(userId);
        return ResponseEntity.ok().body(count);
    }
}
