package com.study.springboot202210dongbin.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IocController {
    // (required = false) 객체 구현 안됐을시 달아주면 해당 부분을 넘길 수 있다. 기본값 true 생략가능
    @Autowired // ioc 컨테이너에 들어있는 component 들을 전부 검토 후 자동으로 DI 해준다.
    @Qualifier("usi3") // ioc 에 component 여러개 있을시에 이름을 달아주어 원하는 component 사용하게 해준다
    private UserService userService;

    @ResponseBody
    @GetMapping("/ioc")
    public String iocTest() {
        userService.createUser();
        userService.getUser();
        userService.updateUser();
        userService.deleteUser();
        return null;
    }
}
