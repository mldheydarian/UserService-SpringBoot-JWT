package com.milad.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "username")
    @Column (name = "user_name", nullable = false, unique = true, length = 50)
    private String userName;
    @Column (name = "password", nullable = false, length = 250)
    private String  password;
    @Column (name = "active")
    private Boolean active;

    @ManyToOne
    @JoinColumn (name = "role_id")
    private Role role;
}
