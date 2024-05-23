package com.ufpso.tienda.category.repository;

import com.ufpso.tienda.article.model.Article;
import com.ufpso.tienda.category.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByNameCategory(String name);
    Optional<Category> findByNameCategoryAndIdNot(String name,Long id);
}
