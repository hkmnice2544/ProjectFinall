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

    @ManyToOne (cascade = CascadeType.ALL )
    @JoinColumn(name = "informrepair_id", nullable = false)
    private InformRepair informRepair;


}
