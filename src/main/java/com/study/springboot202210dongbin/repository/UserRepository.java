package com.study.springboot202210dongbin.repository;

import com.study.springboot202210dongbin.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    public int saveUser(UserDto userDto);
    public UserDto findUserByUserId(int userId);

}
