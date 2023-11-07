package org.itsci.informrepair.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data //Set,Get
@AllArgsConstructor //Constructor
@NoArgsConstructor //NoConstructor
@Entity
@Table(name = "room")
public class Room {

    @Id
    private int room_id;
    @Column(name = "roomtype", nullable = false, length = 50)
    private String roomtype;

    @Column(name = "roomname", nullable = false, length = 100)
    private String roomname;

    @Column(name = "floor", nullable = false, length = 50)
    private String floor;

    @Column(name = "position",length = 50)
    private String position;

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

}
