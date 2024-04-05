package com.ufpso.tienda.category.service;

import com.ufpso.tienda.article.model.Article;
import com.ufpso.tienda.category.model.Category;
import com.ufpso.tienda.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategory(){
        return (List<Category>) categoryRepository.findAll();
    }

    public Category CreateCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).get();
    }

    public Category updateCategory (Category category, Long id){
        Optional<Category> categoryExist = categoryRepository.findById(id);
        categoryExist.get().setNameCategory(category.getNameCategory());
        return categoryRepository.save(categoryExist.get());
    }


    public Boolean delete(Long id){
        Optional<Category> categoryExist = categoryRepository.findById(id);
        categoryRepository.delete(categoryExist.get());
        return true;
    }

    public List<Article> getAllArticleByCategory (Long id){
        Category category = categoryRepository.findById(id).orElse(null);
            return categoryRepository.findAllArticlesByCategory(category);
    }
}
