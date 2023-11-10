//package org.itsci.informrepair.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Date;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "informRepairdetails")
//public class InformRepairDetails {
//    @EmbeddedId
//    private InformRepairDetailsID id;
//
//    @ManyToOne
//    @JoinColumns({
//            @JoinColumn(name = "equipment_id", referencedColumnName = "equipment_id", insertable = false, updatable = false),
//            @JoinColumn(name = "room_id", referencedColumnName = "room_id", insertable = false, updatable = false)
//    })
//    private RoomEquipment roomEquipment;
//
//    @ManyToOne  (cascade = CascadeType.ALL )
//    @JoinColumn(name = "informrepair_id", referencedColumnName = "informrepair_id", insertable = false, updatable = false)
//    @MapsId("informrepair_id")
//    private InformRepair informrepairid;
//
//    @Column(name = "amount", nullable = false, length = 11)
//    private int amount;
//
//    @Column(name = "details", nullable = false)
//    private String details;
//
//    @Column(name = "pictures", nullable = false, length = 100)
//    private String pictures;
//
//
//
//}
