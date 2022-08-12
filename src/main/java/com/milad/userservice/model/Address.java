package com.milad.userservice.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"personality"})
@Data
@Builder
public final class Address extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id", unique = true, nullable = false, updatable = false)
	private Long addressId;

	@Column(name = "tittle")
	private String tittle;
	
	@Column(name = "full_address")
	private String fullAddress;
	
	@Column(name = "postal_code",unique = true)
	private String postalCode;

	private String city;


	@ManyToOne
	@JoinColumn( name = "personality_id",nullable = false )
	private Personality personality;

}










