package com.example.converter;

import com.example.dto.CategoryDTO;
import com.example.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    public CategoryDTO toDTO(CategoryEntity entity){
        CategoryDTO result = new CategoryDTO();
        result.setId(entity.getId());
        result.setName(entity.getName());
        result.setCode(entity.getCode());
        return result;
    }

    public CategoryEntity toEntity(CategoryDTO dto) {
        CategoryEntity result = new CategoryEntity();
        result.setName(dto.getName());
        result.setCode(dto.getCode());
        return result;
    }
}
