package com.ufpso.tienda.category.repository;

import com.ufpso.tienda.article.model.Article;
import com.ufpso.tienda.category.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("SELECT a FROM Article a WHERE a.category = :category")
    List<Article> findAllArticlesByCategory(@Param("category") Category category);
    Optional<Category> findByCategoryName(String name);
}
