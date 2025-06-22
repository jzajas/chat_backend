package com.jzajas.chat.Services.Implementations;

import com.jzajas.chat.Entities.User;
import com.jzajas.chat.Repositories.UserRepository;
import com.jzajas.chat.Services.Interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInterface {

    private final UserRepository userRepository;


    @Override
    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public List<User> findUserByUsername(String username) {
        return userRepository.findAllByUsername(username);
    }

//    TODO exception to change
    @Override
    public User updateUser(User user) {
        User existing = userRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
