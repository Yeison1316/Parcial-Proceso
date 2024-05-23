package com.ufpso.tienda.article.exceptions;

import com.ufpso.tienda.article.model.Article;
import com.ufpso.tienda.article.model.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RestControllerAdvice
public class CustomExceptionHandler{
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response> notFoundExceptionHandle(NotFoundException notFoundException){
        return new ResponseEntity<>(
          Response.builder()
                  .date(LocalDate.now())
                  .message(List.of(notFoundException.getMessage()))
                  .statusCode(HttpStatus.NOT_FOUND.name())
                  .build(),
                    HttpStatus.NOT_FOUND
        );
    }
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<Response> alreadyExistExceptionHandle(AlreadyExistsException alreadyExistsException){
        return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .message(List.of(alreadyExistsException.getMessage()))
                        .statusCode(HttpStatus.NOT_FOUND.name())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<Response> handleValidationsExceptions(
            MethodArgumentNotValidException ex){
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(
                (error) -> {
                    errors.add(
                            ((FieldError) error).getField().concat(
                                    " - "+error.getDefaultMessage()
                            )
                    );
                }
        );
        return new ResponseEntity<>(
                Response.builder()
                        .date(LocalDate.now())
                        .message(List.of("the value must be an integer"))
                        .statusCode(HttpStatus.BAD_REQUEST.name())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }
}
