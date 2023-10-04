package org.itsci.informrepair.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roomequipment")
public class RoomEquipment {

    @EmbeddedId
    private RoomEquipmentId id;


    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    @MapsId("roomId") // ระบุว่า roomId เป็นส่วนหนึ่งของคีย์หลัก
    private Room room;

    @ManyToOne
    @JoinColumn(name = "equipment_id", insertable = false, updatable = false)
    @MapsId("equipmentId") // ระบุว่า equipmentId เป็นส่วนหนึ่งของคีย์หลัก
    private Equipment equipment;



    public void setRoomEquipmentId(RoomEquipmentId roomEquipmentId) {
    }
}
