package org.itsci.informrepair.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Set,Get
@AllArgsConstructor //Constructor
@NoArgsConstructor //NoConstructor
@Entity
@Table(name = "inform_pictures")
public class Inform_pictures {
    @Id
    private int informpictures_id;

    @Column(name = "picture_url", length = 255)
    private String pictureUrl;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "equipment_id", referencedColumnName = "equipment_id"),
            @JoinColumn(name = "room_id", referencedColumnName = "room_id"),
            @JoinColumn(name = "informrepair_id", referencedColumnName = "informrepair_id")
    })
    private InformRepairDetails informRepairDetails;

}