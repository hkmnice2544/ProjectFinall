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
    private int reportpictures_id;

    @Column(name = "pictureUrl", nullable = false, length = 100)
    private String pictureUrl;

    @ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    private Reportrepair reportrepair;


}
