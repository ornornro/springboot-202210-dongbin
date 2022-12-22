package com.study.springboot202210dongbin.service;

import com.study.springboot202210dongbin.repository.EmployeeRepository;
import com.study.springboot202210dongbin.web.dto.EmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public int addEmployee(EmpDto empDto) {
        return employeeRepository.saveEmployee(empDto) > 0 ? empDto.getEmpId() : 0;
    }

}
