package com.jzajas.chat.Controllers;


import com.jzajas.chat.DTO.Input.UserCreationDTO;
import com.jzajas.chat.DTO.Output.UserShowDTO;
import com.jzajas.chat.Entities.User;
import com.jzajas.chat.Services.Interfaces.UserServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceInterface userService;


    @PostMapping("/new")
    public ResponseEntity<User> createNewUser(@RequestBody @Valid UserCreationDTO dto) {
        User user = userService.createNewUser(dto);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserShowDTO> getUser(@PathVariable Long id) {
        UserShowDTO user = userService.getUserById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserShowDTO>> getAllUsers(String username) {
        List<UserShowDTO> users = userService.getUsersByUsername(username);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUserInforamtion(@RequestBody @Valid UserCreationDTO dto,@PathVariable Long id) {
        User newUser = userService.updateUser(dto, id);

        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
