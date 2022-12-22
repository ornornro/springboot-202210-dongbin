package com.study.springboot202210dongbin.repository;

import com.study.springboot202210dongbin.web.dto.EmpDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeRepository {

    public int saveEmployee(EmpDto empDto);

}
