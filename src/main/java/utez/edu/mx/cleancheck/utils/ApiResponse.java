package utez.edu.mx.cleancheck.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ApiResponse <T> {

    private T data;

    private boolean error;

    private int statusCode;

    String message;
}
