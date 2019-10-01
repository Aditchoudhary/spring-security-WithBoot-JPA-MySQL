package com.adit.springsecuritybootjpamysql.service;

import com.adit.springsecuritybootjpamysql.dao.UserRepository;
import com.adit.springsecuritybootjpamysql.model.Role;
import com.adit.springsecuritybootjpamysql.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<Role>();
        roles.add(new Role("USER"));
        user.setRoles(roles);
        userRepository.save(user);
    }
}
