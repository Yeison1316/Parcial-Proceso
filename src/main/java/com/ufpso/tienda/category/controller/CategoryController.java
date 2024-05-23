package com.ufpso.tienda.category.controller;

import com.ufpso.tienda.article.model.Article;
import com.ufpso.tienda.article.model.dto.Response;
import com.ufpso.tienda.category.model.dto.ResponseCategory;
import com.ufpso.tienda.category.model.Category;
import com.ufpso.tienda.category.service.InterfaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private InterfaceService categoryService;

    @GetMapping("/all")
    public ResponseEntity<ResponseCategory> findAll() {
        ResponseCategory response = categoryService.findAllCategory();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCategory> getCategoryById(@PathVariable Long id){
        ResponseCategory responseCategory = categoryService.getCategoryById(id);
            return ResponseEntity.ok().body(responseCategory);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseCategory> create(@RequestBody @Valid Category category){
        ResponseCategory responseCategory = categoryService.createCategory(category);
            return ResponseEntity.ok().body(responseCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCategory> update(@RequestBody @Valid Category category, @PathVariable Long id){
        ResponseCategory responseCategory = categoryService.updateCategory(category,id);
            return ResponseEntity.ok().body(responseCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseCategory> delete(@PathVariable Long id){
        ResponseCategory responseCategory = categoryService.delete(id);
            return ResponseEntity.ok().body(responseCategory);
    }

}
