package org.itsci.informrepair.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class InformRepairDetailsID  implements Serializable {
    @Column(name = "equipment_id")
    private Integer equipment_id;

    @Column(name = "room_id")
    private Integer room_id;

    @Column(name = "informrepair_id")
    private Integer informrepair_id;

    public InformRepairDetailsID(Integer equipment_id, Integer room_id, Integer informrepair_id) {
        this.equipment_id = equipment_id;
        this.room_id = room_id;
        this.informrepair_id = informrepair_id;
    }
}

