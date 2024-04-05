package com.ufpso.tienda.article.controller;

import com.ufpso.tienda.article.model.Article;
import com.ufpso.tienda.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/all")
    public List<Article> findAll() {
        return articleService.findAllArticle();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
            return articleService.getArticleById(id);
    }

    @PostMapping("/create")
    public Article  create(@RequestBody Article article) {
            return  articleService.createArticle(article);
    }

    @PutMapping("/{id}")
    public Article updateArticle(@RequestBody Article article, @PathVariable Long id) {
            return  articleService.updateArticle(article, id);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
            return  articleService.delete(id);
    }

}
