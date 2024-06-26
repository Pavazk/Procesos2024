package com.process.shop.repository;

import com.process.shop.model.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findByBirthDay(LocalDate birthDate);
    //select * from user where email = "?" and id != "?"
    Optional<User> findByEmailAndIdNot(String email, Long id);
}
