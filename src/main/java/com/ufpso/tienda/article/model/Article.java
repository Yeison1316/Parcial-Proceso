package com.ufpso.tienda.article.model;

import com.ufpso.tienda.category.model.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name is required")
    @Size(max = 255, message = "name max 255 characters")
    private String name;

    @NotNull(message = "description is required")
    @Size(max = 255, message = "description max 255 characters")
    private String description;

    @NotNull(message = "stock is required")
    private Number stock;

    @NotNull(message = "price is required")
    @Size(min = 3, max = 15, message = "price max 15 characters and min 3")
    private String price;

    @NotNull(message = "dateOfAdmission is required")
    private Date dateOfAdmission;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

}
