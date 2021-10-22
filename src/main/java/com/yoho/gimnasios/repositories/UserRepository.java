package com.yoho.gimnasios.repositories;

import com.yoho.gimnasios.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from usuarios u where u.name LIKE %?1%")
    Optional<User> findUserByName(String name);
}
