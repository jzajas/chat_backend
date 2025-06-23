package com.jzajas.chat.Services.Implementations;

import com.jzajas.chat.DTO.Input.UserCreationDTO;
import com.jzajas.chat.DTO.Output.UserShowDTO;
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
    public User createNewUser(UserCreationDTO dto) {
        User user = createNewUserFromDTO(dto);
        return userRepository.save(user);
    }

//    TODO implement this to return DTO from database
    @Override
    public UserShowDTO getUserById(Long id) {
//        Optional<UserShowDTO> user = userRepository.findById(id);

        return new UserShowDTO();
    }

//    TODO implement this to return list of DTO from repository
    @Override
    public List<UserShowDTO> getUsersByUsername(String username) {

//        return userRepository.findAllByUsername(username);
        return List.of();
    }

//    TODO exception to change
    @Override
    public User updateUser(UserCreationDTO dto, Long id) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        User newUser = createNewUserFromDTO(dto);
        return userRepository.save(newUser);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


//    TODO implement this method to create user from dto
    private User createNewUserFromDTO(UserCreationDTO dto) {
        User newUSer = new User();
        return newUSer;
    }
}
