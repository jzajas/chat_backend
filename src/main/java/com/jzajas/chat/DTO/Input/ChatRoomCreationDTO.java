package com.jzajas.chat.DTO.Input;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomCreationDTO {

//    TODO more extensive validation (or on the frontend it should be done?)
    @NotNull
    private String name;
}
