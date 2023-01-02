package com.study.springboot202210dongbin.web.controller.account;

import com.study.springboot202210dongbin.aop.annotation.ParamsAspect;
import com.study.springboot202210dongbin.aop.annotation.PrintTestAspect;
import com.study.springboot202210dongbin.aop.annotation.TimerAspect;
import com.study.springboot202210dongbin.aop.annotation.ValidAspect;
import com.study.springboot202210dongbin.service.UserService;
import com.study.springboot202210dongbin.web.dto.CMRespDto;
import com.study.springboot202210dongbin.web.dto.UserDto;
import com.study.springboot202210dongbin.web.dto.UsernameDto;
import com.study.springboot202210dongbin.web.exception.CustomValidException;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    // Simple Log Facade
//    private static final Logger LOG = LoggerFactory.getLogger(AccountApiController.class);

    @Autowired
    private UserService userService;

    // pointCut
    @ParamsAspect
    @TimerAspect
    @ValidAspect
    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(@Valid UsernameDto usernameDto, BindingResult bindingResult) {
        log.info("로그 출력!! 데이터: {}", usernameDto);
        userService.duplicateUsername(usernameDto.getUsername());
        return ResponseEntity.ok().body(new CMRespDto<>("가입 가능한 사용자이름", true));
    }

    @ParamsAspect
    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입 완료", null));
    }

}
