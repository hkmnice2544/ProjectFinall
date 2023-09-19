package org.itsci.informrepair.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inform_pictures")
public class Inform_pictures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int informpictures_id;

    @Column(name = "picture_url", length = 255)
    private String pictureUrl;

    @ManyToOne
    @JoinColumn(name = "informrepair_id") // คอลัมน์ใน "inform_pictures" ที่เชื่อมกับ "roomequipment"
    private InformRepair informRepair;
    // constructors, getters, setters, etc.
}