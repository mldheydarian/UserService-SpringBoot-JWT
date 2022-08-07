package com.milad.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column (name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Column (name = "email", nullable = false, unique = true, length = 50)
    private String email;
    @Column (name = "phone_number", length = 15)
    private String phoneNumber;
    @Column (name = "street", length = 30)
    private String street;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id",nullable = false)
    //TODO:fix nullable
    private User user;

}
