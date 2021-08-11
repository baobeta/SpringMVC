package com.example.api.web;


import com.example.dto.UserDTO;
import com.example.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController(value = "userAPIOfWeb")
public class UserAPI {

    @Autowired
    UserService userService;
    @PostMapping("/api/user")
    public UserDTO createNew(@RequestBody UserDTO userDTO) {
        List<String> roles = new ArrayList<String>();
        roles.add("USER");
        userDTO.setRoles(roles);
        return userService.save(userDTO);
    }
}
