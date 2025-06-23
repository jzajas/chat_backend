package com.jzajas.chat.Services.Interfaces;


import com.jzajas.chat.DTO.Input.UserCreationDTO;
import com.jzajas.chat.DTO.Output.UserShowDTO;
import com.jzajas.chat.Entities.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserServiceInterface {

    @Transactional
    User createNewUser(UserCreationDTO dto);

    @Transactional(readOnly = true)
    UserShowDTO getUserById(Long id);

    @Transactional(readOnly = true)
    List<UserShowDTO> getUsersByUsername(String name);

    @Transactional
    User updateUser(UserCreationDTO dto, Long id);

    @Transactional
    void deleteUserById(Long id);
}
