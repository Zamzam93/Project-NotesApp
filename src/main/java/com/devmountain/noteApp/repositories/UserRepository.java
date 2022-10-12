package com.devmountain.noteApp.repositories;

import com.devmountain.noteApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository clues in spring boot in to keep track of this resource for Dependency Injection

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String String);
}
