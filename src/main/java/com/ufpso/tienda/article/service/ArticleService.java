package com.ufpso.tienda.article.service;

import com.ufpso.tienda.article.model.Article;
import com.ufpso.tienda.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAllArticle(){
        return (List<Article>) articleRepository.findAll();
    }
    public Article updateArticle(Article article){return articleRepository.save(article);}

    public Article createArticle(Article articulo){
        return articleRepository.save(articulo);
    }

    public Article getArticleById(Long id){
        return articleRepository.findById(id).get();
    }

    public Article updateArticle(Article articulo, Long id){
        Optional<Article> articleExist = articleRepository.findById(id);
        articleExist.get().setName(articulo.getName());
        articleExist.get().setDescription(articulo.getDescription());
        articleExist.get().setPrice(articulo.getPrice());
        articleExist.get().setStock(articulo.getStock());
        articleExist.get().setCategory(articulo.getCategory());
        return articleRepository.save(articleExist.get());
    }

    public Boolean delete(Long id){
        Optional<Article> articleExist = articleRepository.findById(id);
        articleRepository.delete(articleExist.get());
        return true;
    }
}
