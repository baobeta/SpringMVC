package com.example.service.impl;

import com.example.converter.UserConverter;
import com.example.dto.UserDTO;
import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.service.IUserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService  implements IUserSevice {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserConverter userConverter;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDTO save(UserDTO userDTO) {
       if(userDTO.getUserName()!=null
               && userDTO.getFullName() !=null
               && userDTO.getPassword()!=null
               && checkPasswordAndRePassword(userDTO.getPassword(), userDTO.getRepassword())
               &&checkUserNameExist(userDTO.getUserName())) {
            UserEntity userEntity = userConverter.toEntity(userDTO);
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setCode("USER");
            roleEntity.setName("Người dùng");
            List<RoleEntity> list = new ArrayList<>();
            list.add(roleEntity);
            userEntity.setRoles(list);
            UserDTO dto = userConverter.toDTO(userRepository.save(userEntity));
            dto.setAlert("SUCCESS");
            return dto;
        } else {
           userDTO.setAlert("EROR");
           return userDTO;
       }



    }
    public boolean checkPasswordAndRePassword(String password , String repassword) {
       if(!password.equals(repassword))  {
           return false;
       } else {
           return true;
       }
    }
    public boolean checkUserNameExist(String userName) {
        UserEntity userEntity = userRepository.findOneByUserNameAndStatus(userName,1);
        if(userEntity != null) {
            return false;
        }else {
            return true;
        }

    }

}
