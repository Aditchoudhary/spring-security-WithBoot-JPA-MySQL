package com.adit.springsecuritybootjpamysql.dao;

import com.adit.springsecuritybootjpamysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
     Optional<User> findByUsername(String username);
}
