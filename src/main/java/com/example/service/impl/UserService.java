package com.example.service.impl;

import com.example.converter.UserConverter;
import com.example.dto.UserDTO;
import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.service.IUserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
               && checkUserNameExist(userDTO.getUserName())
               && userDTO.getPassword().length()!=0) {
            UserEntity userEntity = new UserEntity();
            if(userDTO.getId() != null) {
                UserEntity entity = userRepository.findOne(userDTO.getId());
                List<RoleEntity> list = new ArrayList<>();
                for(String item : userDTO.getRoles()) {
                    RoleEntity roleEntity = roleRepository.findOneByCode(item);
                    list.add(roleEntity);
                }
                entity.setRoles(list);
                userEntity = userConverter.toEntity(entity,userDTO);

            } else {
                userEntity = userConverter.toEntity(userDTO);
                List<RoleEntity> list = new ArrayList<>();
                for(String item : userDTO.getRoles()) {
                    RoleEntity roleEntity = roleRepository.findOneByCode(item);
                    list.add(roleEntity);
                }
                userEntity.setRoles(list);

            }
            UserDTO dto = userConverter.toDTO(userRepository.save(userEntity));
            dto.setAlert("SUCCESS");
            return dto;
        } else {
           userDTO.setAlert("EROR");
           return userDTO;
       }



    }


    @Override
    public List<UserDTO> findAll(Pageable pageable) {
        List<UserDTO> models = new ArrayList<>();
        List<UserEntity> entities = userRepository.findAll(pageable).getContent();
        for (UserEntity item: entities) {
            UserDTO userDTO = userConverter.toDTO(item);
            List<String> roles = new ArrayList<>();
            for (RoleEntity role :item.getRoles()) {
                roles.add(role.getCode());
            }
            models.add(userDTO);
        }
        return models;
    }

    @Override
    public Integer getTotalItem() {
        return (int) userRepository.count();
    }

    @Override
    public UserDTO findById(Long id) {
        UserEntity entity = userRepository.findOne(id);
        UserDTO userDTO = userConverter.toDTO(entity);
        List<String> roles = new ArrayList<>();
        for (RoleEntity role :entity.getRoles()) {
            roles.add(role.getCode());
        }
        userDTO.setRoles(roles);
        return userDTO;
    }

    @Override
    public void delete(long[] ids) {
        for (long id: ids) {
            userRepository.delete(id);
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
