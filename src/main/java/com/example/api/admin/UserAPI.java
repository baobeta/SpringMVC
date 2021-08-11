package com.example.api.admin;

import com.example.dto.NewDTO;
import com.example.dto.UserDTO;
import com.example.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController(value = "userAPIOfAdmin")
public class UserAPI {
    @Autowired
    UserService userService;
    @PostMapping("/admin/api/user")
    public UserDTO createNew(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }
    @PutMapping(value="/admin/api/user")
    public UserDTO updateNew(@RequestBody  UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @DeleteMapping("/admin/api/user")
    public void deleteNew(@RequestBody long[] ids) {
        userService.delete(ids);
    }
}
