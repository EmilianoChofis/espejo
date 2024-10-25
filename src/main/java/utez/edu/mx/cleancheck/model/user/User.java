package utez.edu.mx.cleancheck.model.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import utez.edu.mx.cleancheck.model.role.Role;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor

public class User {
    @Id
    private String id;

    private String name;

    private String email;

    private String password;

    @Column(columnDefinition = "TIMESTAMP DEFAULT NOW()", insertable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String createdAt;

    @Column(columnDefinition = "BOOL DEFAULT TRUE")
    private Boolean status;

    @Column(columnDefinition = "BOOL DEFAULT true")
    private Boolean blocked;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
