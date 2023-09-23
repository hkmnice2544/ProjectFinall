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

    @EmbeddedId
    private RoomEquipmentId id;

    @ManyToOne
    @MapsId("room_id") // ระบุว่าใช้คอลัมน์ room_id เป็นส่วนหนึ่งของคีย์หลักร่วม
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @MapsId("equipment_id") // ระบุว่าใช้คอลัมน์ equipment_id เป็นส่วนหนึ่งของคีย์หลักร่วม
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

}
