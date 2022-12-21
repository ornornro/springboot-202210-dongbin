package com.study.springboot202210dongbin.web.controller;

import com.study.springboot202210dongbin.service.OptionService;
import com.study.springboot202210dongbin.web.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController // controller 는 요청과 응답을 처리한다
@RequestMapping("/api/option")
public class OptionController {

    @Autowired
    private OptionService optionService;

    @PostMapping("/category")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity
                .created(URI.create("/api/option/category" + optionService.addCategory(categoryDto)))
                .body(categoryDto);
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories() {

        return ResponseEntity.ok(optionService.getCategories());
    }

    // 하나만 들고오기 유저 들고오기 까지 작업할것

    // 수정
    @PutMapping("/category/{categoryId}")
    public ResponseEntity<?> modifyCategory(@PathVariable int categoryId, @RequestBody CategoryDto categoryDto) {
        optionService.moveCategory(categoryId, categoryDto);
        return ResponseEntity.ok(true);
    }

}
