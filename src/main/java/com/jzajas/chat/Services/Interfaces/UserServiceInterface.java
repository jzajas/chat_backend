package com.jzajas.chat.Services.Interfaces;


import com.jzajas.chat.Entities.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserServiceInterface {

    @Transactional
    User createNewUser(User user);

    @Transactional(readOnly = true)
    User findUserById(Long id);

    @Transactional(readOnly = true)
    List<User> findUserByUsername(String name);

    @Transactional
    User updateUser(User user);

    @Transactional
    void deleteUserById(Long id);
}
