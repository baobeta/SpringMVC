package com.example.service;

import com.example.dto.NewDTO;
import com.example.model.NewModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewService {
    List<NewDTO> findAll(Pageable pageable);
    int getTotalItem();
}
