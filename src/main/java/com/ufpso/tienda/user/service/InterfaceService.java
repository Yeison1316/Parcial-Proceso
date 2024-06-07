package com.ufpso.tienda.user.service;

import com.ufpso.tienda.user.model.User;
import com.ufpso.tienda.user.model.dto.ResponseUser;

public interface InterfaceService {
    ResponseUser createUser(User user);
    ResponseUser findAllUser();
    ResponseUser updateUser(User user, Long id);
    ResponseUser getUserById(Long id);
    ResponseUser deleteUser(Long id);
}
