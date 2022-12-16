package com.study.springboot202210dongbin.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data // dto 에 이 네개는 필수다
public class UserDto {

    private int userId;
    private String userName;
    private String password;
    private String name;
    private String email;

}
