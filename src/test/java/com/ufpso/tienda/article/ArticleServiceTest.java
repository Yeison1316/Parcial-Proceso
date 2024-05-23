package com.ufpso.tienda.article;

import com.ufpso.tienda.article.exceptions.AlreadyExistsException;
import com.ufpso.tienda.article.exceptions.NotFoundException;
import com.ufpso.tienda.article.model.Article;
import com.ufpso.tienda.article.model.dto.Response;
import com.ufpso.tienda.article.model.enums.ErrorMessages;
import com.ufpso.tienda.article.model.enums.SuccessMessages;
import com.ufpso.tienda.article.repository.ArticleRepository;
import com.ufpso.tienda.article.exceptions.CustomResponseHandler;
import com.ufpso.tienda.article.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArticleServiceTest {

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private CustomResponseHandler responseHandler;

    @InjectMocks
    private ArticleService articleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testFindAllArticle() {
        List<Article> articles = List.of(new Article(), new Article());

        when(articleRepository.findAll()).thenReturn(articles);

        Response expectedResponse = Response.builder()
                .date(LocalDate.now())
                .message(List.of(SuccessMessages.GET_ARTICLE.getMessage()))
                .statusCode("200")
                .article(articles)
                .build();

        when(responseHandler.createResponseArticle(SuccessMessages.GET_ARTICLE, articles, "200"))
                .thenReturn(expectedResponse);

        Response actualResponse = articleService.findAllArticle();

        assertEquals(expectedResponse, actualResponse);
        verify(articleRepository).findAll();
        verify(responseHandler).createResponseArticle(SuccessMessages.GET_ARTICLE, articles, "200");
    }

    @Test
    void testCreateArticle() {
        Article article = new Article();
        article.setName("Test Article");

        when(articleRepository.findByName(article.getName())).thenReturn(Optional.empty());
        when(articleRepository.save(article)).thenReturn(article);

        Response expectedResponse = Response.builder()
                .date(LocalDate.now())
                .message(List.of(SuccessMessages.ARTICLE_CREATE.getMessage()))
                .statusCode("201")
                .article(List.of(article))
                .build();

        when(responseHandler.createResponseArticle(SuccessMessages.ARTICLE_CREATE, List.of(article), "201"))
                .thenReturn(expectedResponse);

        Response actualResponse = articleService.createArticle(article);

        assertEquals(expectedResponse, actualResponse);
        verify(articleRepository).findByName(article.getName());
        verify(articleRepository).save(article);
        verify(responseHandler).createResponseArticle(SuccessMessages.ARTICLE_CREATE, List.of(article), "201");
    }
    @Test
    void testCreateArticleAlreadyExists() {
        Article article = new Article();
        article.setName("Test Article");

        when(articleRepository.findByName(article.getName())).thenReturn(Optional.of(article));

        AlreadyExistsException exception = assertThrows(AlreadyExistsException.class, () -> {
            articleService.createArticle(article);
        });

        assertEquals(ErrorMessages.ARTICLE_NAME_EXIST.getMessage(), exception.getMessage());
        verify(articleRepository).findByName(article.getName());
        verify(articleRepository, never()).save(any());
        verify(responseHandler, never()).createResponseArticle(any(), any(), any());
    }

    @Test
    void testGetArticleById() {
        Article article = new Article();
        article.setId(1L);

        when(articleRepository.findById(article.getId())).thenReturn(Optional.of(article));

        Response expectedResponse = Response.builder()
                .date(LocalDate.now())
                .message(List.of(SuccessMessages.GET_ARTICLE.getMessage()))
                .statusCode("200")
                .article(List.of(article))
                .build();

        when(responseHandler.createResponseArticle(SuccessMessages.GET_ARTICLE, List.of(article), "200"))
                .thenReturn(expectedResponse);

        Response actualResponse = articleService.getArticleById(article.getId());

        assertEquals(expectedResponse, actualResponse);
        verify(articleRepository).findById(article.getId());
        verify(responseHandler).createResponseArticle(SuccessMessages.GET_ARTICLE, List.of(article), "200");
    }

    @Test
    void testGetArticleByIdNotFound() {
        Long id = 1L;

        when(articleRepository.findById(id)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            articleService.getArticleById(id);
        });

        assertEquals(ErrorMessages.ARTICLE_NOT_FOUND.getMessage(), exception.getMessage());
        verify(articleRepository).findById(id);
        verify(responseHandler, never()).createResponseArticle(any(), any(), any());
    }

    @Test
    void testUpdateArticle() {
        Long id = 1L;
        Article article = new Article();
        article.setName("Updated Article");

        Article existingArticle = new Article();
        existingArticle.setId(id);

        when(articleRepository.findById(id)).thenReturn(Optional.of(existingArticle));
        when(articleRepository.findByNameAndIdNot(article.getName(), id)).thenReturn(Optional.empty());
        when(articleRepository.save(existingArticle)).thenReturn(existingArticle);

        Response expectedResponse = Response.builder()
                .date(LocalDate.now())
                .message(List.of(SuccessMessages.ARTICLE_UPDATE.getMessage()))
                .statusCode("200")
                .article(List.of(existingArticle))
                .build();

        when(responseHandler.createResponseArticle(SuccessMessages.ARTICLE_UPDATE, List.of(existingArticle), "200"))
                .thenReturn(expectedResponse);

        Response actualResponse = articleService.updateArticle(article, id);

        assertEquals(expectedResponse, actualResponse);
        verify(articleRepository).findById(id);
        verify(articleRepository).findByNameAndIdNot(article.getName(), id);
        verify(articleRepository).save(existingArticle);
        verify(responseHandler).createResponseArticle(SuccessMessages.ARTICLE_UPDATE, List.of(existingArticle), "200");
    }

    @Test
    void testUpdateArticleNotFound() {
        Long id = 1L;
        Article article = new Article();

        when(articleRepository.findById(id)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            articleService.updateArticle(article, id);
        });

        assertEquals(ErrorMessages.ARTICLE_NOT_FOUND.getMessage(), exception.getMessage());
        verify(articleRepository).findById(id);
        verify(articleRepository, never()).findByNameAndIdNot(any(), any());
        verify(articleRepository, never()).save(any());
        verify(responseHandler, never()).createResponseArticle(any(), any(), any());
    }

    @Test
    void testUpdateArticleNameExists() {
        Long id = 1L;
        Article article = new Article();
        article.setName("Existing Name");

        Article existingArticle = new Article();
        existingArticle.setId(id);

        when(articleRepository.findById(id)).thenReturn(Optional.of(existingArticle));
        when(articleRepository.findByNameAndIdNot(article.getName(), id)).thenReturn(Optional.of(new Article()));

        AlreadyExistsException exception = assertThrows(AlreadyExistsException.class, () -> {
            articleService.updateArticle(article, id);
        });

        assertEquals(ErrorMessages.ARTICLE_NAME_EXIST.getMessage(), exception.getMessage());
        verify(articleRepository).findById(id);
        verify(articleRepository).findByNameAndIdNot(article.getName(), id);
        verify(articleRepository, never()).save(any());
        verify(responseHandler, never()).createResponseArticle(any(), any(), any());
    }

    @Test
    void testDeleteArticle() {
        Long id = 1L;
        Article existingArticle = new Article();
        existingArticle.setId(id);

        when(articleRepository.findById(id)).thenReturn(Optional.of(existingArticle));

        Response expectedResponse = Response.builder()
                .date(LocalDate.now())
                .message(List.of(SuccessMessages.DELETE_ARTICLE.getMessage()))
                .statusCode("200")
                .article(List.of(existingArticle))
                .build();

        when(responseHandler.createResponseArticle(SuccessMessages.DELETE_ARTICLE, List.of(existingArticle), "200"))
                .thenReturn(expectedResponse);

        Response actualResponse = articleService.delete(id);

        assertEquals(expectedResponse, actualResponse);
        verify(articleRepository).findById(id);
        verify(articleRepository).delete(existingArticle);
        verify(responseHandler).createResponseArticle(SuccessMessages.DELETE_ARTICLE, List.of(existingArticle), "200");
    }

    @Test
    void testDeleteArticleNotFound() {
        Long id = 1L;

        when(articleRepository.findById(id)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            articleService.delete(id);
        });

        assertEquals(ErrorMessages.ARTICLE_NOT_FOUND.getMessage(), exception.getMessage());
        verify(articleRepository).findById(id);
        verify(articleRepository, never()).delete(any());
        verify(responseHandler, never()).createResponseArticle(any(), any(), any());
    }

}