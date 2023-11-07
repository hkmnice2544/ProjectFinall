package org.itsci.informrepair.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data //Set,Get
@AllArgsConstructor //Constructor
@NoArgsConstructor //NoConstructor
@Entity
@Table(name = "user")
public class User {
    @Getter
    @Id
    private int user_id;

    @Column(name = "usertype", nullable = false, length = 50)
    private String usertype;

    @Column(name = "firstname", nullable = false, length = 100)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 100)
    private String lastname;

    @Column(name = "username", nullable = false, length = 16)
    private String username;

    @Column(name = "password", nullable = false, length = 16)
    private String password;

    @Column(name = "mobile", nullable = false, length = 10)
    private String mobile;

    public int getUser_id() {
        return user_id;
    }
}
