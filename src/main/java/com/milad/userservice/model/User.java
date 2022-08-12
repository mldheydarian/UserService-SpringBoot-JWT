package com.milad.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Builder
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false, updatable = false)
    private Long userId;


    @Column (name = "user_name", nullable = false, unique = true, length = 50)
    private String userName;
    @Column (name = "password", nullable = false, length = 250)
    private String  password;
    @Column (name = "active")
    private Boolean active;


    @ManyToOne
    @JoinColumn (name = "role_id", nullable = false)
    private Role role;

    //in cascade bod ke save nemikard

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "personality_id", nullable = false)
    //TODO:fix nullable
    private Personality personality;
}
