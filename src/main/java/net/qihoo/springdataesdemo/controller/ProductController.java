package net.qihoo.springdataesdemo.controller;

import lombok.RequiredArgsConstructor;
import net.qihoo.springdataesdemo.entity.Product;
import net.qihoo.springdataesdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
//    @Autowired
//    private final ProductService productService;
//
//    @PostMapping
//    public Product createProduct(@RequestBody Product product) {
//        return productService.save(product);
//    }
//
//    @GetMapping("/search")
//    public List<Product> searchByName(@RequestParam String name) {
//        return productService.findByName(name);
//    }
}