package com.aws.spring_study.repository;

import com.aws.spring_study.dto.ModifyUserReqDto;
import com.aws.spring_study.dto.RegisterUserReqDto;
import com.aws.spring_study.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMappers {
    public Integer saveUser(RegisterUserReqDto registerUserReqDto);     //xml에 없으면 빨간줄 뜸
    //인터페이스는 클래스에서 재정의해야 사용 가능 -> xml에서 구현!
    public List<User> getUserListAll();
    //User getUserListAll(); 이렇게하면 결과를 하나만 가져올 수 있음, 여러 개를 받기 위해 List안에 유저를 저장
    public Integer updateUser(ModifyUserReqDto modifyUserReqDto);
    public Integer deleteUser(int userId);
}
