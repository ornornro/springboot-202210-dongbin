package com.study.springboot202210dongbin.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data // dto 에 이 네개는 필수다
public class UserDto {
    private int userId;
    @Pattern(regexp = "^[a-zA-Z0-9]{5,20}$", message = "사용자이름은 영문, 숫자 조합이어야하며 5자 이상 20자 이하로 작성하세요")
    private String username;

    private String password;
    @Pattern(regexp = "^[가-힣]{2,5}$", message = "이름은 한글만 작성이 가능하며 2자 이상 5자 이하까지만 입력가능합니다")
    private String name;
    @NotBlank(message = "이메일을 입력해주세요")
    @Email
    private String email;

}
