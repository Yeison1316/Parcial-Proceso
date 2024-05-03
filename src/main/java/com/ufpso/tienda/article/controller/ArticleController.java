package com.ufpso.tienda.article.controller;
import com.ufpso.tienda.article.model.Article;
import com.ufpso.tienda.article.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private InterfaceService articleService;

    @GetMapping("/all")
    public ResponseEntity<List<Article>> findAll() {
         return ResponseEntity.ok().body(articleService.findAllArticle());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        return ResponseEntity.ok().body(articleService.getArticleById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Article>  create(@RequestBody Article article) {
        return ResponseEntity.status(HttpStatus.CREATED).body(articleService.createArticle(article));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article, @PathVariable Long id) {
        return ResponseEntity.ok().body(articleService.updateArticle(article, id));
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return articleService.delete(id);
    }

}
