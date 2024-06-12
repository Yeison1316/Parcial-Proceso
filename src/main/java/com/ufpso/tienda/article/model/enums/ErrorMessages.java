package com.ufpso.tienda.article.model.enums;

import lombok.Getter;
@Getter
public enum ErrorMessages {
    ARTICLE_NOT_FOUND("Article not found!"),
    ARTICLE_NAME_EXIST("The name is already exist!"),
    CATEGORY_NOT_FOUND("Category not found!"),
    CATEGORY_NAME_EXIST("The name is already exist!"),
    USER_NOT_FOUND("User not found!"),
    USER_NAME_EXIST("The name is already exist!"),
    USER_EMAIL_EXISTS("The email is already registered"),
    CREDENTIAL_INVALID("The credentials is invalid");

    private  final  String message;
    ErrorMessages(String message){
        this.message = message;
    }
}
