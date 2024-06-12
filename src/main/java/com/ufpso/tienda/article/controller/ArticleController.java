package com.ufpso.tienda.article.controller;
import com.ufpso.tienda.article.model.Article;
import com.ufpso.tienda.article.service.InterfaceService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ufpso.tienda.article.model.dto.Response;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private InterfaceService articleService;

    @GetMapping("/all")
    public ResponseEntity<Response> findAll() {
        Response response = articleService.findAllArticle();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getArticleById(@PathVariable @Min(1) Long id) {
        Response article = articleService.getArticleById(id);
        return ResponseEntity.ok().body(article);
    }

    @PostMapping("/create")
    public ResponseEntity<Response> create(@RequestBody @Valid Article article) {
        Response response = articleService.createArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Response> updateArticle(@RequestBody @Valid Article article, @PathVariable @Min(1) Long id) {
        Response response = articleService.updateArticle(article, id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable @Min(1) Long id) {
        Response response = articleService.delete(id);
        return ResponseEntity.ok().body(response);
    }

}
