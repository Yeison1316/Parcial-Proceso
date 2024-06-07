package com.ufpso.tienda.user.controller;

import com.ufpso.tienda.user.model.User;
import com.ufpso.tienda.user.model.dto.ResponseUser;
import com.ufpso.tienda.user.service.InterfaceService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class UserController {

    @Autowired
    private InterfaceService userService;

    @GetMapping("/all")
    public ResponseEntity<ResponseUser> findAll() {
        ResponseUser response = userService.findAllUser();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUser> getUserById(@PathVariable @Min(1) Long id) {
        ResponseUser article = userService.getUserById(id);
        return ResponseEntity.ok().body(article);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseUser> create(@RequestBody @Valid User user) {
        ResponseUser response = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ResponseUser> updateUser(@RequestBody @Valid User user, @PathVariable @Min(1) Long id) {
        ResponseUser response = userService.updateUser(user, id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseUser> delete(@PathVariable @Min(1) Long id) {
        ResponseUser response = userService.deleteUser(id);
        return ResponseEntity.ok().body(response);
    }
}
