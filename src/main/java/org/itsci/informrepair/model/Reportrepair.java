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
@Table(name = "reportrepair")
public class Reportrepair {

	@Id
	private int report_id;
	
	private String repairer;
	private Date reportdate;
	private String details;
	private String status;
	private Date statusdate;


	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "equipment_id", referencedColumnName = "equipment_id"),
			@JoinColumn(name = "room_id", referencedColumnName = "room_id"),
			@JoinColumn(name = "informrepair_id", referencedColumnName = "informrepair_id")
	})
	private InformRepairDetails informRepairDetails;




}
