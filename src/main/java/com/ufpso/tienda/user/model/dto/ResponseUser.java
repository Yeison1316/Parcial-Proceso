package com.ufpso.tienda.user.model.dto;

import com.ufpso.tienda.user.model.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class ResponseUser {
    private LocalDate date;
    private List<String> message;
    private String statusCode;
    private List<User> user;
}
