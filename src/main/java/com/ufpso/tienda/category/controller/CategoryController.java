package com.ufpso.tienda.category.controller;

import com.ufpso.tienda.article.model.Article;
import com.ufpso.tienda.category.model.Category;
import com.ufpso.tienda.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/all")
    public List<Category> finAll(){
            return categoryService.findAllCategory();
        }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
            return categoryService.getCategoryById(id);
    }

    @PostMapping("/create")
    public Category create(@RequestBody Category category){
            return categoryService.CreateCategory(category);
    }

    @PutMapping("/{id}")
    public Category update(@RequestBody Category category, @PathVariable Long id){
            return categoryService.updateCategory(category, id);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id){
            return categoryService.delete(id);
    }

    @GetMapping("/article/{id}")
    public List<Article> getAllArticlesByCategory(@PathVariable Long id) {
            List<Article> articles = categoryService.getAllArticleByCategory(id);
            return articles;
    }
}
