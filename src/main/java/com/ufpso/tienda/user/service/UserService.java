package com.ufpso.tienda.user.service;

import com.ufpso.tienda.article.exceptions.AlreadyExistsException;
import com.ufpso.tienda.article.exceptions.CustomResponseHandler;
import com.ufpso.tienda.article.exceptions.NotFoundException;
import com.ufpso.tienda.article.model.enums.ErrorMessages;
import com.ufpso.tienda.article.model.enums.SuccessMessages;
import com.ufpso.tienda.user.model.dto.ResponseUser;
import com.ufpso.tienda.user.model.User;
import com.ufpso.tienda.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService  implements InterfaceService {

    private final UserRepository userRepository;
    private final CustomResponseHandler responseHandler;

    @Autowired
    public UserService(UserRepository userRepository, CustomResponseHandler responseHandler) {
        this.userRepository = userRepository;
        this.responseHandler = responseHandler;
    }

    @Override
    public ResponseUser findAllUser() {
        List<User> user = (List<User>) userRepository.findAll();
        if (user.isEmpty()){
            throw new NotFoundException(ErrorMessages.USER_NOT_FOUND.getMessage());
        }
        return responseHandler.createResponseUser(SuccessMessages.GET_USER, user, "200");
    }

    public ResponseUser createUser(User user) {
        Optional<User> users = userRepository.findByFullName(user.getFullName());
        if (users.isPresent()) {
            throw new AlreadyExistsException(ErrorMessages.USER_NAME_EXIST.getMessage());
        }
        User savedUser = userRepository.save(user);
        return responseHandler.createResponseUser(SuccessMessages.USER_CREATE, List.of(savedUser), "201");
    }
    @Override
    public ResponseUser getUserById(Long id) {
        Optional<User> userExist = userRepository.findById(id);
        if (userExist.isEmpty()) {
            throw new NotFoundException(ErrorMessages.USER_NOT_FOUND.getMessage());
        }
        return responseHandler.createResponseUser(SuccessMessages.GET_USER, List.of(userExist.get()), "200");
    }

    @Override
    public ResponseUser updateUser(User user, Long id) {
        Optional<User> userExist = userRepository.findById(id);
        if (userExist.isEmpty()) {
            throw new NotFoundException(ErrorMessages.USER_NOT_FOUND.getMessage());
        }
        Optional<User> userFindByName = userRepository.findByFullNameAndIdNot(user.getFullName(), id);
        if (userFindByName.isPresent()) {
            throw new AlreadyExistsException(ErrorMessages.USER_NAME_EXIST.getMessage());
        }
        User updatedUser = userExist.get();
        updatedUser.setFullName(user.getFullName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setBirthDay(user.getBirthDay());
        updatedUser.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(updatedUser);
        return responseHandler.createResponseUser(SuccessMessages.USER_UPDATE, List.of(updatedUser), "200");
    }
    @Override
    public ResponseUser deleteUser(Long id) {
        Optional<User> userExist = userRepository.findById(id);
        if (userExist.isEmpty()) {
            throw new NotFoundException(ErrorMessages.USER_NOT_FOUND.getMessage());
        }
        userRepository.delete(userExist.get());
        return responseHandler.createResponseUser(SuccessMessages.DELETE_USER, List.of(userExist.get()), "200");
    }

}
