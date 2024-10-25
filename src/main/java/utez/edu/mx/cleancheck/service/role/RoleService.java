package utez.edu.mx.cleancheck.service.role;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.cleancheck.controller.role.dto.RoleDto;
import utez.edu.mx.cleancheck.model.role.Role;
import utez.edu.mx.cleancheck.model.role.RoleRepository;
import utez.edu.mx.cleancheck.utils.ApiResponse;

import java.sql.SQLException;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor

public class RoleService {

    private final RoleRepository repository;

    @Transactional(rollbackFor = {SQLException.class})
    public ApiResponse<Role> create (RoleDto role) {
        Role foundRole = repository.findByName(role.getName()).orElse(null);
        if (foundRole != null) {
            return new ApiResponse<>(
                    foundRole, true, HttpStatus.BAD_REQUEST.value(), "El rol ingresado ya esta registrado"
            );
        }
        Role newRole = new Role();
        String id = UUID.randomUUID().toString();
        newRole.setId(id);
        newRole.setName(role.getName());
        newRole.setDescription(role.getDescription());
        Role saveRole = repository.save(newRole);
        return new ApiResponse<>(
                saveRole, false, HttpStatus.OK.value(), "Rol registrado correctamente"
        );
    }
}
