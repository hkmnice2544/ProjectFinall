package org.itsci.informrepair.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Set,Get
@AllArgsConstructor //Constructor
@NoArgsConstructor //NoConstructor
@Entity
@Table(name = "review_pictures")
public class Review_pictures {

    @Id
    private int reviewpictures_id;

    @Column(name = "pictureUrl", nullable = false, length = 100)
    private String pictureUrl;

    @ManyToOne
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;

}
