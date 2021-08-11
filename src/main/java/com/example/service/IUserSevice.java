package com.example.service;

import com.example.dto.NewDTO;
import com.example.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserSevice {
    UserDTO save (UserDTO userDTO);

    List<UserDTO> findAll(Pageable pageable);

    Integer getTotalItem();

    UserDTO findById(Long id);

    void delete(long[] ids);
}
