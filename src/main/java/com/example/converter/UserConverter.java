package com.example.converter;

import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Qualifier("encoder")
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO toDTO (UserEntity entity) {
        UserDTO result = new UserDTO();
        result.setId(entity.getId());
        result.setUserName(entity.getUserName());
        result.setPassword(entity.getPassword());
        result.setFullName(entity.getFullName());
        return result;

    }
    public UserEntity toEntity (UserDTO dto) {
        UserEntity result = new UserEntity();
        result.setUserName(dto.getUserName());
        result.setPassword(passwordEncoder.encode(dto.getPassword()));
        result.setFullName(dto.getFullName());
        result.setStatus(1);
        return result;

    }
    public UserEntity toEntity (UserEntity entity, UserDTO dto) {
        entity.setUserName(dto.getUserName());
        entity.setFullName(dto.getFullName());
        return entity;
    }
}
