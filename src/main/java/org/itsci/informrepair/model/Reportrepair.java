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
	private Date enddate;
	private String details;


	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "informrepair_id", referencedColumnName = "informrepair_id")
	})
	private InformRepair informRepair;



}
