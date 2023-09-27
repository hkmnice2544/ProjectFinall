package org.itsci.informrepair.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data //Set,Get
@AllArgsConstructor //Constructor
@NoArgsConstructor //NoConstructor
@Entity
@Table(name = "informRepairdetails")
public class InformRepairDetails {
    @Id
    private int informdetails_id;

    private int amount;
    private String details;

    @ManyToOne
    @JoinColumn(name = "informrepair_id")
    private InformRepair informRepair;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "equipment_id", referencedColumnName = "equipment_id"),
            @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    })
    private RoomEquipment roomEquipment;


    public void setInformrepair_id(Integer integer) {
    }

    public void setTotalAmount(Integer integer) {
    }

    public void setStatus(String s) {
    }

    public void setInformDate(Date date) {
    }
}
