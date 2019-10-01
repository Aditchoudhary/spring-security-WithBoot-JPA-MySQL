package com.adit.springsecuritybootjpamysql.service;

import com.adit.springsecuritybootjpamysql.dao.UserRepository;
import com.adit.springsecuritybootjpamysql.model.MyUserDetail;
import com.adit.springsecuritybootjpamysql.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(s);
        user.orElseThrow(() -> new UsernameNotFoundException("UserName : " + s + " is not found"));
        return user.map(MyUserDetail::new).get();
    }
}
