package com.ufpso.tienda.category.model.dto;
import com.ufpso.tienda.category.model.Category;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class ResponseCategory {
    private LocalDate date;
    private List<String> message;
    private String statusCode;
    private List<Category> category;
}
