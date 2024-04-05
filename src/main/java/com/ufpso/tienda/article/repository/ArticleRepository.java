package com.ufpso.tienda.article.repository;

import com.ufpso.tienda.article.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
