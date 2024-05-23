package com.ufpso.tienda.article.service;

import com.ufpso.tienda.article.exceptions.AlreadyExistsException;
import com.ufpso.tienda.article.exceptions.NotFoundException;
import com.ufpso.tienda.article.exceptions.CustomResponseHandler;
import com.ufpso.tienda.article.model.Article;
import com.ufpso.tienda.article.model.dto.Response;
import com.ufpso.tienda.article.model.enums.ErrorMessages;
import com.ufpso.tienda.article.model.enums.SuccessMessages;
import com.ufpso.tienda.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements InterfaceService{

    private final ArticleRepository articleRepository;
    private final CustomResponseHandler responseHandler;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, CustomResponseHandler responseHandler) {
        this.articleRepository = articleRepository;
        this.responseHandler = responseHandler;
    }

    @Override
    public Response findAllArticle() {
        List<Article> articles = (List<Article>) articleRepository.findAll();
        if (articles.isEmpty()){
            throw new NotFoundException(ErrorMessages.ARTICLE_NOT_FOUND.getMessage());
        }
        return responseHandler.createResponseArticle(SuccessMessages.GET_ARTICLE, articles, "200");
    }

    public Response createArticle(Article articulo) {
        Optional<Article> article = articleRepository.findByName(articulo.getName());
        if (article.isPresent()) {
            throw new AlreadyExistsException(ErrorMessages.ARTICLE_NAME_EXIST.getMessage());
        }
        Article savedArticle = articleRepository.save(articulo);
        return responseHandler.createResponseArticle(SuccessMessages.ARTICLE_CREATE, List.of(savedArticle), "201");
    }
    @Override
    public Response getArticleById(Long id) {
        Optional<Article> articleExist = articleRepository.findById(id);
        if (articleExist.isEmpty()) {
            throw new NotFoundException(ErrorMessages.ARTICLE_NOT_FOUND.getMessage());
        }
        return responseHandler.createResponseArticle(SuccessMessages.GET_ARTICLE, List.of(articleExist.get()), "200");
    }

    @Override
    public Response updateArticle(Article articulo, Long id) {
        Optional<Article> articleExist = articleRepository.findById(id);
        if (articleExist.isEmpty()) {
            throw new NotFoundException(ErrorMessages.ARTICLE_NOT_FOUND.getMessage());
        }
        Optional<Article> articleFindByName = articleRepository.findByNameAndIdNot(articulo.getName(), id);
        if (articleFindByName.isPresent()) {
            throw new AlreadyExistsException(ErrorMessages.ARTICLE_NAME_EXIST.getMessage());
        }
        Article updatedArticle = articleExist.get();
        updatedArticle.setName(articulo.getName());
        updatedArticle.setDescription(articulo.getDescription());
        updatedArticle.setPrice(articulo.getPrice());
        updatedArticle.setStock(articulo.getStock());
        updatedArticle.setCategory(articulo.getCategory());
        articleRepository.save(updatedArticle);
        return responseHandler.createResponseArticle(SuccessMessages.ARTICLE_UPDATE, List.of(updatedArticle), "200");
    }

    @Override
    public Response delete(Long id) {
        Optional<Article> articleExist = articleRepository.findById(id);
        if (articleExist.isEmpty()) {
            throw new NotFoundException(ErrorMessages.ARTICLE_NOT_FOUND.getMessage());
        }
        articleRepository.delete(articleExist.get());
        return responseHandler.createResponseArticle(SuccessMessages.DELETE_ARTICLE, List.of(articleExist.get()), "200");
    }
}
