package com.study.springboot202210dongbin.repository;

import com.study.springboot202210dongbin.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper // Mapper 을 달아주면 인터페이스와 xml 을 연결시켜 준다
public interface UserRepository {

    public int saveUser(UserDto userDto); // xml 의 아이디와 동일해야만 한다
    public UserDto findUserByUserId(int userId);

}
