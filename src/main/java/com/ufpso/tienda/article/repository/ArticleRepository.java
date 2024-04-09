package com.ufpso.tienda.article.repository;

import com.ufpso.tienda.article.model.Article;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    Optional<User> findByEmail(String email);
    List<User> findByBirthDay(LocalDate BirthDay);
}
