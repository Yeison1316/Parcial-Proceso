package com.ufpso.tienda.category.service;

import com.ufpso.tienda.article.model.dto.Response;
import com.ufpso.tienda.category.model.Category;
import com.ufpso.tienda.category.model.dto.ResponseCategory;

public interface InterfaceService {
    ResponseCategory createCategory(Category category);
    ResponseCategory findAllCategory();
    ResponseCategory updateCategory(Category category,Long id);
    ResponseCategory getCategoryById(Long id);
    ResponseCategory delete(Long id);
}
