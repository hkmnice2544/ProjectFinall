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
	
	private String reviewer;
	private Date reviewdate;
	private String repairscore; 
	private String comment;

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "report_id")
	private Reportrepair reportrepair;


}