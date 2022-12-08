package com.study.springboot202210dongbin.IocAndDi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
일반 component 와의 차이점은 똑같이 bean 등록이 가능하지만 configuration 은 2개 이상 bean 등록이 가능하다
나머지는 1개만
언제 configuration 을 사용하는가? gson 라이브러리에 소스 수정을 못하니까,
component 는 등록할 수 없지만 Ioc 에 등록하고 싶은 경우에 사용한다
 */

@Configuration // component 동일한 기능을 하지만 사용목적이 다름 수동적으로 Ioc 에 bean 을 강제적으로 등록가능
public class TestConfig {

    @Bean
    public Test1 test1() {
        return new Test1();
    }

    @Bean
    public Test2 test2() {
        return new Test2();
    }

}
