package com.ufpso.tienda.article.service;

import com.ufpso.tienda.article.model.Article;
import com.ufpso.tienda.article.model.dto.Response;

import java.util.List;
public interface InterfaceService {
    Response createArticle(Article article);
    Response findAllArticle();
    Response updateArticle(Article article,Long id);
    Response getArticleById(Long id);
    Response delete(Long id);
}
