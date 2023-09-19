package org.itsci.informrepair.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Set,Get
@AllArgsConstructor //Constructor
@NoArgsConstructor //NoConstructor
@Entity
@Table(name = "report_pictures")
public class Report_pictures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int report_id;

    @Column(name = "picture_url", length = 255)
    private String pictureUrl;

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Reportrepair reportrepair;


}
