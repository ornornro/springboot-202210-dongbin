package com.study.springboot202210dongbin.web.controller;

import com.study.springboot202210dongbin.web.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProductTestController {

    @GetMapping("/product/addition")
    public String loadAddition() {
        return "product/product_add";
    }

//    @PostMapping("/api/product")
//    public String registerProduct(HttpServletRequest request) {
//        System.out.println(request.getParameter("price"));
//
//        return "product/product_view";
//    }

    // 변수명과 파라미터가 같으면 밑에 productName 처럼 생략해서 사용가능 파라미터는 왠만하면 붙여주기!
//    @PostMapping("/api/product")
//    public String registerProduct(String productName,
//                                  @RequestParam("productCode") String  pc,
//                                  @RequestParam("price") int p,
//                                  @RequestParam("stock") int s) {
//        System.out.println(p);
//        System.out.println(productName);
//        System.out.println(s);
//        System.out.println(pc);
//
//        return "product/product_view";
//    }

    @PostMapping("/api/product")
    public String registerProduct(Model model, ProductDto productDto) {
        model.addAttribute("productDto", productDto);
        System.out.println(productDto);

        return "product/product_view";
    }

    @GetMapping("/product/addition2")
    public String loadAddition2() {
        return "product/product_add2";
    }

    @ResponseBody // 데이터 응답 없으면 뷰리턴 이게 있다면 view, viewResolver 가 필요없다
    @PostMapping("/api/product/2")
    public String registerProduct(ProductDto productDto) {
        System.out.println(productDto);

        return productDto.toString();
    }
}
