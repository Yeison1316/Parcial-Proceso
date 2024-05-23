package com.ufpso.tienda.article.model.enums;

import lombok.Getter;
@Getter
public enum SuccessMessages {
    ARTICLE_CREATE("Article create!"),
    ARTICLE_UPDATE("Update Aricle OK!"),
    GET_ARTICLE("Successful article query"),
    DELETE_ARTICLE("Article successful removal"),
    CATEGORY_CREATE("Category create!"),
    CATEGORY_UPDATE("Update Caegory!"),
    GET_CATEGORY("Successful category query"),
    DELETE_CATEGORY("Category successful removal");


    private final String message;

    SuccessMessages(String message) {
        this.message = message;
    }
}
