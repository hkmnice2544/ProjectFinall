package org.itsci.informrepair.model;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RoomEquipmentId implements Serializable {

    private int equipment_id;
    private int room_id;

    // เพิ่ม constructors และ methods อื่น ๆ ตามต้องการ

}