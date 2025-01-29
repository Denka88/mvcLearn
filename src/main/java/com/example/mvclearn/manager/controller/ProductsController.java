package com.example.mvclearn.manager.controller;

import com.example.mvclearn.manager.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("catalogue/products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("list")
    public String getProductList(Model model){
        model.addAttribute("products", this.productService.findAllProducts());
        return "catalogue/products/list";
    }
    @GetMapping("create")
    public String getNewProductPage(){
        return "catalogue/products/new_product";
    }

}
