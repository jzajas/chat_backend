package com.jzajas.chat.DTO.Input;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDTO {

//    TODO more extensive creation validation (or at frontend?)
    @NotNull
    private String username;

    @NotNull
    private String password;
}
