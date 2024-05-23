package com.ufpso.tienda.category.service;

import com.ufpso.tienda.article.exceptions.AlreadyExistsException;
import com.ufpso.tienda.article.exceptions.CustomResponseHandler;
import com.ufpso.tienda.article.exceptions.NotFoundException;
import com.ufpso.tienda.article.model.enums.SuccessMessages;
import com.ufpso.tienda.category.model.dto.ResponseCategory;
import com.ufpso.tienda.article.model.enums.ErrorMessages;
import com.ufpso.tienda.category.model.Category;
import com.ufpso.tienda.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements InterfaceService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CustomResponseHandler responseHandler;

    public ResponseCategory findAllCategory(){
        List<Category> category = (List<Category>) categoryRepository.findAll();
        return responseHandler.createResponseCategory(SuccessMessages.GET_CATEGORY,category,"200");
    }

    public ResponseCategory createCategory(Category category){
        Optional<Category> categoryExist = categoryRepository.findByNameCategory(category.getNameCategory());
        if(categoryExist.isPresent()){
            throw  new AlreadyExistsException(ErrorMessages.CATEGORY_NAME_EXIST.getMessage());
        }
        Category savedCategory = categoryRepository.save(category);
        return responseHandler.createResponseCategory(SuccessMessages.CATEGORY_CREATE,List.of(savedCategory),"200");
    }

    public ResponseCategory getCategoryById(Long id){
        Optional<Category> categoryExist = categoryRepository.findById(id);
        if(categoryExist.isEmpty()){
            throw  new NotFoundException(ErrorMessages.CATEGORY_NOT_FOUND.getMessage());
        }
        return responseHandler.createResponseCategory(SuccessMessages.GET_CATEGORY,List.of(categoryExist.get()),"200");
    }

    public ResponseCategory updateCategory (Category category, Long id){
        Optional<Category> categoryExist = categoryRepository.findById(id);
        if(categoryExist.isEmpty()){
            throw  new NotFoundException(ErrorMessages.CATEGORY_NOT_FOUND.getMessage());
        }
        categoryExist.get().setNameCategory(category.getNameCategory());
        Category category1 = categoryRepository.save(categoryExist.get());
        return responseHandler.createResponseCategory(SuccessMessages.CATEGORY_UPDATE,List.of(category1),"200");
    }
    public ResponseCategory delete(Long id){
        Optional<Category> categoryExist = categoryRepository.findById(id);
        if(categoryExist.isEmpty()){
            throw  new NotFoundException(ErrorMessages.CATEGORY_NOT_FOUND.getMessage());
        }
        categoryRepository.delete(categoryExist.get());
        return responseHandler.createResponseCategory(SuccessMessages.DELETE_CATEGORY,List.of(categoryExist.get()),"200");
    }
}
