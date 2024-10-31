package utez.edu.mx.cleancheck.model.floor;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import utez.edu.mx.cleancheck.model.building.Building;
import utez.edu.mx.cleancheck.model.room.Room;

import java.util.List;

@Entity
@Table(name = "floors")
@Data
@NoArgsConstructor

public class Floor {
    @Id
    private String id;

    private int number;

    private String name;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building buildingId;

    @OneToMany(mappedBy = "floorId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms;

}
