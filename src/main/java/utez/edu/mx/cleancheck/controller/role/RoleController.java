package utez.edu.mx.cleancheck.controller.role;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.cleancheck.controller.role.dto.RoleDto;
import utez.edu.mx.cleancheck.model.role.Role;
import utez.edu.mx.cleancheck.service.role.RoleService;
import utez.edu.mx.cleancheck.utils.ApiResponse;

@RestController
@RequestMapping("/api-clean/role")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor

public class RoleController {

    private final RoleService service;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Role>> create (@Valid @RequestBody RoleDto role) {
        try {
            ApiResponse<Role> response = service.create(role);
            HttpStatus statusCode = response.isError() ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
            return new ResponseEntity<>(
                    response,
                    statusCode
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ApiResponse<>(
                            null, true, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
