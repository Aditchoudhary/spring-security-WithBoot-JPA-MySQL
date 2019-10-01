package com.adit.springsecuritybootjpamysql.api;

import com.adit.springsecuritybootjpamysql.model.User;
import com.adit.springsecuritybootjpamysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApis {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/user")
    public String welcomeUser() {
        return new String("<h1>Welcome User</h1>");
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String saveUser(@RequestBody User user) {

        userService.saveUser(user);
        return "success";
    }

    @RequestMapping(path = "/admin")
    public String welcomeAdmin() {
        return new String("<h1>Welcome Admin</h1>");
    }

}
