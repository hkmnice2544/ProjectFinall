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

    @Column(name = "equipmentname", nullable = false, length = 100)
    private String equipmentname;

    @ManyToOne
	@JoinColumn(name = "room_id", nullable = false)
	private Room room;




}
