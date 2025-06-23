package com.jzajas.chat.DTO.Output;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserShowDTO {

//    TODO more extensive creation validation (or at frontend?)
    @NotNull
    private String username;

    @NotNull
    private Date createdAt;
}
