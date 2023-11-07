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

	@Column(name = "repairer", nullable = false, length = 100)
	private String repairer;

	@Column(name = "reportdate", nullable = false)
	private Date reportdate;

	@Column(name = "details", nullable = false)
	private String details;

	@Column(name = "status", nullable = false, length = 50)
	private String status;

	@Column(name = "statusdate", nullable = false)
	private Date statusdate;


	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "equipment_id", referencedColumnName = "equipment_id", nullable = false),
			@JoinColumn(name = "room_id", referencedColumnName = "room_id", nullable = false),
			@JoinColumn(name = "informrepair_id", referencedColumnName = "informrepair_id", nullable = false)
	})
	private InformRepairDetails informRepairDetails;



}
