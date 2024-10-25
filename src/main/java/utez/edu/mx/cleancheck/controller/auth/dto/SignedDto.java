package utez.edu.mx.cleancheck.controller.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import utez.edu.mx.cleancheck.model.user.User;

@Data
@AllArgsConstructor

public class SignedDto {

    String token;
    User user;
}
