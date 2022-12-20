package com.study.springboot202210dongbin.service;

import com.study.springboot202210dongbin.repository.OptionRepository;
import com.study.springboot202210dongbin.web.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionService {

    @Autowired
    private OptionRepository optionRepository;

    public int addCategory(CategoryDto categoryDto) {
        return optionRepository.saveCategory(categoryDto) > 0 ? categoryDto.getCategoryId() : 0;
    }
}