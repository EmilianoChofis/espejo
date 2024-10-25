package utez.edu.mx.cleancheck.controller.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class SignDto {

    @NotBlank(message = "El email es requerido")
    @Email(message = "El email no es valido")
    private String email;

    @NotBlank(message = "La contraseña es requerida")
    @Size(min = 8, message = "La contraseña debe contener al menos 8 caracteres")
    private String password;
}
