package com.process.shop.service;

import com.process.shop.exceptions.AlreadyExistsException;
import com.process.shop.exceptions.NotFoundException;
import com.process.shop.model.User;
import com.process.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.process.shop.model.enunm.ErrorMessages.USER_EMAIL_EXISTS;
import static com.process.shop.model.enunm.ErrorMessages.USER_NOT_FOUND;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        Optional<User> userFindByEmail = userRepository.findByEmail(user.getEmail());
        if (userFindByEmail.isPresent()) {
            throw new AlreadyExistsException(USER_EMAIL_EXISTS.getMessage());
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User userUpdated, Long id) {
        Optional<User> userBb = userRepository.findById(id);
        if (userBb.isEmpty()) {
            throw new NotFoundException(USER_NOT_FOUND.getMessage());
        }
        User userToUpdate = userBb.get();
        Optional<User> userFindByEmail = userRepository.findByEmailAndIdNot(userUpdated.getEmail(), userUpdated.getId());
        if (userFindByEmail.isPresent()) {
            throw new AlreadyExistsException(USER_EMAIL_EXISTS.getMessage());
        }
        userToUpdate.setEmail(userUpdated.getEmail());
        userToUpdate.setFullName(userUpdated.getFullName());
        userToUpdate.setPhone(userUpdated.getPhone());
        return userRepository.save(userToUpdate);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userBb = userRepository.findById(id);
        if (userBb.isEmpty()) {
            throw new NotFoundException(USER_NOT_FOUND.getMessage());
        }
        return userBb.get();
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
