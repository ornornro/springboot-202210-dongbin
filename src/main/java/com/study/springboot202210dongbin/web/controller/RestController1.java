package com.study.springboot202210dongbin.web.controller;

import com.study.springboot202210dongbin.web.dto.CMRespDto;
import com.study.springboot202210dongbin.web.dto.UserDto;
import com.study.springboot202210dongbin.web.exception.CustomTestException;
import com.sun.net.httpserver.Headers;
import org.apache.catalina.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestController1 {

    @GetMapping("/api/test/user-dto/str")
    public String getUserDtoStr() {
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("123")
                .build();
        return userDto.toString(); // string 으로 응답시 text/plain
    }

    @GetMapping("/api/test/user-dto/obj")
    public ResponseEntity<?> getUserDtoObj() {
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("123")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("UserDto", userDto.toString());
//        return new ResponseEntity<>(headers, HttpStatus.OK);
        return ResponseEntity.ok()
                .headers(headers)
                .body(userDto); // builder 패턴은 가능한 아래로 써줘야 보기좋음
//        return new ResponseEntity<>(userDto, HttpStatus.BAD_REQUEST); // 객체로 응답시 자동으로 json 으로 만들어준다
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(userDto); // 위 식이랑 같지만 더 직관적이라 선호
    }

    @GetMapping("/api/test/user-dto/cm")
    public ResponseEntity<?> getUserDto() {
        UserDto userDto = UserDto.builder()
                .username("test")
                .password("1234")
                .build();
        return ResponseEntity.ok().body(new CMRespDto<>("test 유저 정보 응답", userDto)); // 공통 응답 객체
    }

    @PostMapping("/api/test/user")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {

        if(userDto.getUsername().isBlank()) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("username", "아이디를 입력하세요.");

            throw new CustomTestException("유효성 검사 실패", errorMap);
        }

        userDto.setUserId(200);
        return ResponseEntity.created(null)
                .body(new CMRespDto<>(userDto.getUserId() + "사용자 추가 성공!", userDto));

    }

}
