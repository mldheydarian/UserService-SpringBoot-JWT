package com.milad.userservice.dto;

import lombok.*;

import java.io.Serializable;


public class UserAuthenticationResponseDto implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwtToken;


    public UserAuthenticationResponseDto(String jwttoken) {
        this.jwtToken = jwttoken;
    }

    public String getToken() {
        return this.jwtToken;
    }
    }
