package com.agence.agence.models;

import com.agence.agence.enums.User_Role;
import com.agence.agence.enums.User_Sexe;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/***
 * by :Michel B
 * nature : user entity
 *
 */


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Size(min = 2, max = 30)
    @Column(nullable = false, length = 30)
    private String name;

    @Size(min = 2 , max = 25)
    @Column(length = 25)
    private String prenom;

    @Size(min = 4, max = 15)
    @Column(unique = true, nullable = false, length = 15)
    private String login;

    @Size(min = 6, max = 15)
    @Column(nullable = false, length = 15)
    private String mdp;

    @Size(min = 20 , max = 50)
    @Column(unique = true, nullable = false, length = 50)
    @Email
    private String  email;

    @Size(min = 6)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 6)
    private User_Role userRole;

    @Size(min = 6)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 6)
    private User_Sexe userSexe;

    @OneToMany(mappedBy = "user" )
    private  List<Commentaire> commentaires;

    @ManyToMany(mappedBy = "users")
    private List<Vehicule> vehicules;

    @ManyToMany
    @JoinTable(name = "Reserver", joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idCalendrier"))
    private List<Calendrier> calendars;



}
