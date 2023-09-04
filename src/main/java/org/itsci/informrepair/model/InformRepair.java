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

	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "user_id")
	})
	private User user;





}
