package com.example.converter;

import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserDTO toDTO (UserEntity entity) {
        UserDTO result = new UserDTO();
        result.setUserName(entity.getUserName());
        result.setPassword(entity.getPassword());
        result.setFullName(entity.getFullName());
        return result;

    }
    public UserEntity toEntity (UserDTO dto) {
        UserEntity result = new UserEntity();
        result.setUserName(dto.getUserName());
        result.setPassword(dto.getPassword());
        result.setFullName(dto.getFullName());
        result.setStatus(1);
        return result;

    }
}
