package com.ufpso.tienda.article.model.enums;

import lombok.Getter;
@Getter
public enum ErrorMessages {
    ARTICLE_NOT_FOUND("Article not found!"),
    ARTICLE_NAME_EXIST("The name is already exist!"),
    CATEGORY_NOT_FOUND("Category not found!"),
    CATEGORY_NAME_EXIST("The name is already exist!");

    private  final  String message;
    ErrorMessages(String message){
        this.message = message;
    }
}
