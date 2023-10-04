package org.itsci.informrepair.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import javax.persistence.Column;
import java.io.Serializable;

@Embeddable
public class RoomEquipmentId implements Serializable {

    private Integer equipmentId;
    private Integer roomId;


    public RoomEquipmentId(Integer equipmentId, Integer roomId) {
        this.equipmentId = equipmentId;
        this.roomId = roomId;
    }


    public RoomEquipmentId() {

    }
}
