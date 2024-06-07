package com.ufpso.tienda.article.exceptions;

import com.ufpso.tienda.article.model.Article;
import com.ufpso.tienda.article.model.dto.Response;
import com.ufpso.tienda.article.model.enums.SuccessMessages;
import com.ufpso.tienda.category.model.Category;
import com.ufpso.tienda.category.model.dto.ResponseCategory;
import com.ufpso.tienda.user.model.User;
import com.ufpso.tienda.user.model.dto.ResponseUser;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CustomResponseHandler {

    public Response createResponseArticle(SuccessMessages message, List<Article> articles, String statusCode) {
        return Response.builder()
                .date(LocalDate.now())
                .message(List.of(message.getMessage()))
                .statusCode(statusCode)
                .article(articles)
                .build();
    }
    public ResponseCategory createResponseCategory(SuccessMessages message, List<Category> category, String statusCode) {
        return ResponseCategory.builder()
                .date(LocalDate.now())
                .message(List.of(message.getMessage()))
                .statusCode(statusCode)
                .category(category)
                .build();
    }
    public ResponseUser createResponseUser(SuccessMessages message, List<User> user, String statusCode) {
        return ResponseUser.builder()
                .date(LocalDate.now())
                .message(List.of(message.getMessage()))
                .statusCode(statusCode)
                .user(user)
                .build();
    }
}
