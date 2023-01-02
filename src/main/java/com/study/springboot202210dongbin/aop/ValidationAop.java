package com.study.springboot202210dongbin.aop;

import com.study.springboot202210dongbin.web.exception.CustomValidException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ValidationAop {

    @Pointcut("execution(* com.study.springboot202210dongbin.web.controller.account.AccountApiController.*(..))")
    private void executionPointCut() {}

    @Pointcut("@annotation(com.study.springboot202210dongbin.aop.annotation.ValidAspect)")
    private void annotationPointCut() {}

    @Around("annotationPointCut()") // 전과 후 둘 다 적용시켜라
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();
        for(Object arg : args) {
            System.out.println(arg);
        }
        System.out.println("AOP 작동함!!");

        BeanPropertyBindingResult bindingResult = null;

        for (Object arg : args) {
            if(arg.getClass() == BeanPropertyBindingResult.class) {
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }

        if(bindingResult != null) {
            if (bindingResult.hasErrors()) {
                Map<String, String> errorMap = new HashMap<>();
                bindingResult.getFieldErrors().forEach(error -> {
                    errorMap.put(error.getField(), error.getDefaultMessage());
                });

                throw new CustomValidException(errorMap);
            }
        }

        // 밑에 줄 실행 전에 aop 무조건 실행
        // 메소드 호출 전 처리
        Object returnValue =  proceedingJoinPoint.proceed(); // proceed = 우리가 지정한 실행된 메소드 위 포인트에서!
        // 메소드 호출 후 처리

        return returnValue;

    }

}
