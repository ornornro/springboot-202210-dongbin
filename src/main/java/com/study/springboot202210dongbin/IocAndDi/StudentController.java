package com.study.springboot202210dongbin.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // component 가 상의고 component 의 한 종류이다 하위에서 나뉜다, 동일하게 Ioc 에 등록된다
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private Test1 test1;

    @Autowired
    private Test2 test2;

    @ResponseBody
    @GetMapping("/student")
    public String printStudent() {
        Student student = Student.builder()
                .studentId(2001)
                .studentName("김경민")
                .build();

        test1.print();
        test2.print();

        studentService.printStudentInfo(student);
        return null;
    }
}
