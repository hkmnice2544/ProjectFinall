package org.itsci.informrepair.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Set,Get
@AllArgsConstructor //Constructor
@NoArgsConstructor //NoConstructor
@Entity
@Table(name = "roomequipment")
public class RoomEquipment {

    @Id
    private int equipment_id;
    @Id
    private int room_id;

    private String status;

    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "equipment_id", insertable = false, updatable = false)
    private Equipment equipment;
}
