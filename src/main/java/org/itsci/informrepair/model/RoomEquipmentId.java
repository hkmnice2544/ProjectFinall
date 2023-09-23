package org.itsci.informrepair.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import javax.persistence.Column;
import java.io.Serializable;

@Embeddable
public class RoomEquipmentId implements Serializable {

    @Column(name = "equipment_id")
    private Integer equipment_id;

    @Column(name = "room_id")
    private Integer room_id;

    public RoomEquipmentId(Integer equipment_id, Integer room_id) {
        this.equipment_id = equipment_id;
        this.room_id = room_id;
    }


    public RoomEquipmentId() {

    }
}
