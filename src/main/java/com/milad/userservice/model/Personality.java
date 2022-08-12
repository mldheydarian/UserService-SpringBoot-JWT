package com.milad.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "personality")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Personality extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personality_id", unique = true, nullable = false, updatable = false)
    private Long personalityId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email(message = "*Input must be in Email format!**")
    @Column(name="email",unique = true, nullable = false)
    private String email;

    @Column(name = "image_url")
    private String imageUrl;

    private String phone;


    @OneToMany(mappedBy = "personality", fetch = FetchType.LAZY)
    private List<Address> addresses;

    @OneToOne(mappedBy = "personality" , fetch = FetchType.LAZY)
    private User user;


}
