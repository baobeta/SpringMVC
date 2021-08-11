package com.example.converter;

import com.example.dto.RoleDTO;
import com.example.entity.RoleEntity;

public class RoleConverter {
    public RoleDTO toDTO(RoleEntity entity) {
        RoleDTO result = new RoleDTO();
        result.setName(entity.getName());
        result.setCode(entity.getCode());
        return result;
    }
}
