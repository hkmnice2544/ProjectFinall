package org.itsci.informrepair.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data //Set,Get
@AllArgsConstructor //Constructor
@NoArgsConstructor //NoConstructor
@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    private int equipment_id;

    private String equipmentname;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "roomequipment",
            joinColumns = {@JoinColumn(name = "equipment_id")},
            inverseJoinColumns = {@JoinColumn(name = "informrepair_id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"equipment_id", "room_id"})})
    private Set<InformRepair> informRepairs = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "roomequipment",
            joinColumns = {@JoinColumn(name = "equipment_id")},
            inverseJoinColumns = {@JoinColumn(name = "room_id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"equipment_id", "informrepair_id"})})
    private Set<Room> rooms = new HashSet<Room>();


}
