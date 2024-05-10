package com.ufpso.tienda.article.service;

import com.ufpso.tienda.article.exceptions.AlreadyExistsException;
import com.ufpso.tienda.article.exceptions.NotFoundException;
import com.ufpso.tienda.article.model.Article;
import com.ufpso.tienda.article.model.enums.ErrorMessages;
import com.ufpso.tienda.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements InterfaceService{

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAllArticle(){
        return (List<Article>) articleRepository.findAll();
    }

    public Article createArticle(Article articulo){
        Optional<Article> article = articleRepository.findByName(articulo.getName());
        if(article.isPresent()){
            throw  new AlreadyExistsException(ErrorMessages.ARTICLE_NAME_EXIST.getMessage());
        }
        return articleRepository.save(articulo);
    }

    public Article getArticleById(Long id){
        Optional<Article> articleExist =  articleRepository.findById(id);
        if(articleExist.isEmpty()){
            throw  new NotFoundException(ErrorMessages.ARTICLE_NOT_FOUND.getMessage());
        }
        return articleExist.get();
    }

    public Article updateArticle(Article articulo, Long id){
        Optional<Article> articleExist = articleRepository.findById(id);
        if(articleExist.isEmpty()){
            throw  new NotFoundException(ErrorMessages.ARTICLE_NOT_FOUND.getMessage());
        }
        Optional<Article> articleFindByName = articleRepository.findByNameAndIdNot(articulo.getName(),id);
        if(articleFindByName.isPresent()){
            throw  new AlreadyExistsException(ErrorMessages.ARTICLE_NAME_EXIST.getMessage());
        }
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
