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
@Table(name = "review")
public class Review {

	@Id
	private int review_id;

	@Column(name = "reviewer", nullable = false, length = 100)
	private String reviewer;

	@Column(name = "repairer", nullable = false)
	private Date reviewdate;

	@Column(name = "repairscore", nullable = false, length = 1)
	private String repairscore;

	@Column(name = "comment", nullable = false)
	private String comment;

	@ManyToOne (cascade = CascadeType.ALL )
	@JoinColumn(name = "report_id", nullable = false)
	private Reportrepair reportrepair;

}