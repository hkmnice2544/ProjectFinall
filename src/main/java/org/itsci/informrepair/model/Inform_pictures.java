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
    @JoinColumn(name = "informdetails_id") // คอลัมน์ใน "inform_pictures" ที่เชื่อมกับ "roomequipment"
    private InformRepairDetails informRepairDetails;




}