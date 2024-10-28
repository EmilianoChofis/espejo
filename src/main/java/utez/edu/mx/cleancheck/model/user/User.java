package utez.edu.mx.cleancheck.model.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utez.edu.mx.cleancheck.model.role.Role;

import java.util.Date;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private String id;

    private String name;

    private String email;

    private String password;

    @Column(name = "created_at", insertable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @Column(columnDefinition = "BOOL DEFAULT TRUE")
    private Boolean status;

    @Column(columnDefinition = "BOOL DEFAULT true")
    private Boolean blocked;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User(String name, String email, String password, Boolean status, Boolean blocked, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
        this.blocked = blocked;
        this.role = role;
    }

}
