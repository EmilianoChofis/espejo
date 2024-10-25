package utez.edu.mx.cleancheck.controller.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class UserDto {

    private String name;
    private String email;
    private String password;
}
