package com.study.springboot202210dongbin.repository;

import com.study.springboot202210dongbin.web.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OptionRepository {
    public int saveCategory(CategoryDto categoryDto);
}
