package org.itsci.informrepair.model;
        import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        import java.io.Serializable;
        import java.util.Date;
        import java.util.HashSet;
        import java.util.Set;

@Data //Set,Get
@AllArgsConstructor //Constructor
@NoArgsConstructor //NoConstructor

@Entity
@Table(name = "inform_pictures")
public class Inform_pictures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int informpictures_id;

    @Column(name = "picture_url", length = 255)
    private String pictureUrl;

    @ManyToOne
    @JoinColumn(name = "informrepair_id")
    private InformRepair informRepair;


}
