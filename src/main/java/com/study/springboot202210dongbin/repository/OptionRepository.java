package com.study.springboot202210dongbin.repository;

import com.study.springboot202210dongbin.web.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OptionRepository {
    public int saveCategory(CategoryDto categoryDto);
    public List<CategoryDto> getCategories(); // 여러개를 get 할때
    public int modifyCategory(CategoryDto categoryDto);
}
