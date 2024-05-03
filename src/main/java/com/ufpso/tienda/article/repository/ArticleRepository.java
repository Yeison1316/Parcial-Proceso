package com.ufpso.tienda.article.repository;

import com.ufpso.tienda.article.model.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    Optional<Article> findByName(String name);
    List<Article> findByDescription(String description);
    Optional<Article> findByNameAndIdNot(String name,Long id);

}
