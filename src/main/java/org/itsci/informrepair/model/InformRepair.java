package org.itsci.informrepair.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data //Set,Get
@AllArgsConstructor //Constructor
@NoArgsConstructor //NoConstructor
@Entity
@Table(name = "informrepair")
public class InformRepair {


	@Id
	private int informrepair_id;


	private Date informdate;
	private String informdetails;
	private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany(fetch = FetchType.EAGER) // กำหนด FetchType เป็น EAGER เพื่อโหลดข้อมูลแบบอัตโนมัติ
	@JoinTable(name = "roomequipment",
			joinColumns = {@JoinColumn(name = "informrepair_id")},
			inverseJoinColumns = {@JoinColumn(name = "equipment_id")},
			uniqueConstraints = {@UniqueConstraint(columnNames = {"informrepair_id", "room_id"})})
	private Set<Room> rooms = new HashSet<Room>();

	@ManyToMany(fetch = FetchType.EAGER) // กำหนด FetchType เป็น EAGER เพื่อโหลดข้อมูลแบบอัตโนมัติ
	@JoinTable(name = "roomequipment",
			joinColumns = {@JoinColumn(name = "informrepair_id")},
			inverseJoinColumns = {@JoinColumn(name = "room_id")},
			uniqueConstraints = {@UniqueConstraint(columnNames = {"informrepair_id", "equipment_id"})})
	private Set<Equipment> equipment = new HashSet<Equipment>();

	public InformRepair(Integer informrepair_id, Date informdate, String informdetails, String status, User user) {
		this.informrepair_id = informrepair_id;
		this.informdate = informdate;
		this.informdetails = informdetails;
		this.status = status;
		this.user = user;
	}

}
