package com.example.mvclearn.manager.controller;

import com.example.mvclearn.manager.entity.Product;
import com.example.mvclearn.manager.payload.NewProductPayload;
import com.example.mvclearn.manager.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("create")
    private String createProduct(NewProductPayload payload){
        Product product = this.productService.createProduct(payload.title(), payload.details());
        return "redirect:/catalogue/products/list";
    }
    
    @GetMapping("{productId:\\d+}")
    public String getProduct(@PathVariable("productId") int productId, Model model){
        model.addAttribute("product", this.productService.findProduct(productId).orElseThrow());
        return "catalogue/products/product";
    }
}