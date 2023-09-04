package org.itsci.informrepair.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data //Set,Get
@AllArgsConstructor //Constructor
@NoArgsConstructor //NoConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    private int user_id;

    private String usertype;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String mobile;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "roomequipment",
            joinColumns= { @JoinColumn(name = "equipment_id")},
            inverseJoinColumns= { @JoinColumn(name = "room_id")})
//    private List<Room> room;
    private Set<Room> rooms = new HashSet<Room>();

}
