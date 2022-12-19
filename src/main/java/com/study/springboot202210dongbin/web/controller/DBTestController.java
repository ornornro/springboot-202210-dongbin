package com.study.springboot202210dongbin.web.controller;

import com.study.springboot202210dongbin.service.UserService;
import com.study.springboot202210dongbin.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController // 일반 컨트롤러랑 rest 컨트롤러의 차이 일반은 html 응답할때 사용 rest 컨트롤러는 데이터 응답
@RequestMapping("/api/db/test") // 경로가 중복되는 부분을 따로 빼준다
public class DBTestController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) { // Json 으로 보낼땐 무조건 @RequestBody 를 단다
        System.out.println(userDto); // client 가 가지고 있던 Dto 가 컨트롤러한테 정상적으로 전달했다
        int userId = userService.addUser(userDto);
//        return new ResponseEntity<>("응답할 데이터", HttpStatus.CREATED);
        return ResponseEntity.created(URI.create("/api/db/test/user/" + userId)).body(userDto); // builder 형식
    }

    @GetMapping("/user/{userId}") // {변수명} 왜 이렇게 쓰냐면 get 요청이라 아이디가 계속 변한다 @PathVariable 같이씀
    public ResponseEntity<?> getUser(@PathVariable int userId) {
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok().body(userDto);
    }

}
