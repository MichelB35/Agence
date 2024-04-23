package com.agence.agence.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

/***
 * by :Michel B
 * nature : user entity
 *
 */


@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Size(min = 2, max = 30,message = "il vous faut avoir un minimum de 2 et un maximum de 30 caractèress")
    @Column(nullable = false, length = 30)
    private String nom;

    @Size(min = 2 , max = 25, message = "il vous faut avoir un minimum de 2 et un maximum de 25 caractèress")
    @Column(length = 25)
    private String prenom;

    @Size(min = 4, max = 8, message = "il vous faut avoir un minimum de 4 et un maximum de 8 caractèress")
    @Column(unique = true, nullable = false, length = 8)
    @Pattern(regexp = "^[a-z]+$", message = "le login se doit de contenir uniquement des caractère miniscules")
    private String login;

    @Size(min = 6, max = 15,message = "il vous faut avoir un minimum de 6 et un maximum de 15 caractèress")
    @Column(nullable = false, length = 15)
    private String mdp;

    @Size(min =10 , max = 50, message = "il vous faut avoir un minimum de 20 et un maximum de 50 caractèress")
    @Column(unique = true, nullable = false, length = 50)
    @Email
    private String  email;

    @Size(min = 4)
    @Column(nullable = false, length = 7)
    private String userRole;

    @Size(min = 5)
    @Column(nullable = false, length = 5)
    private String userSexe;

    @OneToMany(mappedBy = "user" )
    private  List<Commentaire> commentaires;

    @OneToMany(mappedBy = "user" )
    private  List<Reservation> reservations ;

    @ManyToMany(mappedBy = "users")
    private List<Vehicule> vehicules;

    @OneToMany(mappedBy = "user")
    List<Calendrier> calendriers;
    @ManyToMany
    @JoinTable(name = "Reserver", joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idCalendrier"))
    private List<Calendrier> calendars;


}
