package com.ufpso.tienda.article.service;

import com.ufpso.tienda.article.model.Article;

import java.util.List;
public interface InterfaceService {
    Article createArticle(Article article);
    List<Article> findAllArticle();
    Article updateArticle(Article article,Long id);
    Article getArticleById(Long id);
    Boolean delete(Long id);
}
