package com.ufpso.tienda.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "name is required")
    private String fullName;
    @NotNull(message = "BirthDay is required")
    private Date birthDay;
    @NotNull(message = "Document is required")
    private String document;
    @NotNull(message = "PhoneNumber is required")
    private String phoneNumber;
    @NotNull(message = "Email is required")
    private String email;
    @NotNull(message = "Password is required")
    private String password;
    //private List<Address> address;
}
