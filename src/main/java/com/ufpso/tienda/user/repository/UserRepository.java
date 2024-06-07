package com.ufpso.tienda.user.repository;

import com.ufpso.tienda.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByFullName(String fullName);
    List<User> findByDocument(String document);
    Optional<User> findByFullNameAndIdNot(String fullName,Long id);
}
