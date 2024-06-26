package com.ufpso.tienda.article.model.dto;

import com.ufpso.tienda.article.model.Article;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Builder
@Data
public class Response{
    private LocalDate date;
    private List<String> message;
    private String statusCode;
    private List<Article> article;
}
