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

	@Column(name = "informdate", nullable = false)
	private Date informdate;

	@Column(name = "informtype", nullable = false, length = 100)
	private String informtype;

	@Column(name = "status", nullable = false, length = 50)
	private String status;

	@Column(name = "amount", nullable = false, length = 11)
    private int amount;

    @Column(name = "details", nullable = false)
    private String details;

    @Column(name = "pictures", nullable = false, length = 100)
    private String pictures;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "equipment_id", nullable = false)
	private Equipment equipment;


}
