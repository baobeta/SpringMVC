package com.example.service.impl;

import com.example.dto.RoleDTO;
import com.example.entity.CategoryEntity;
import com.example.entity.RoleEntity;
import com.example.repository.RoleRepository;
import com.example.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<String> findAll() {
        List<String> list = new ArrayList<String>();
        List<RoleEntity> entities = roleRepository.findAll();
        for(RoleEntity item : entities) {
            list.add(item.getCode());
        }
        return list;
    }
}
