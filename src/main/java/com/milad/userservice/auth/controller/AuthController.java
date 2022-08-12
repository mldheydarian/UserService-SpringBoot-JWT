package com.milad.userservice.auth.controller;

import com.milad.userservice.auth.model.AuthenticationRequest;
import com.milad.userservice.auth.model.AuthenticationResponse;
import com.milad.userservice.auth.util.JwtUtil;
import com.milad.userservice.dto.UserDto;
import com.milad.userservice.model.User;
import com.milad.userservice.auth.util.impl.JwtUtilImpl;
import com.milad.userservice.service.UserService;
import com.milad.userservice.auth.service.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @Autowired
    JwtUtil jwtUtils;


    @PostMapping("/signup")
    public ResponseEntity<UserDto> singup(@RequestBody UserDto userDto) {

        userService.save(userDto);
        return ResponseEntity.status(200).body(userDto);
    }


    @PostMapping("/signin")
    public ResponseEntity<?> singin(@RequestBody AuthenticationRequest userAuthReqDto) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAuthReqDto.getUsername(), userAuthReqDto.getPassword()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Login failed: \n" + e.getMessage());
        }

        // If User exists in context then
        // add fetch user in security context by UserDetailsService loadUserByUsername() ???
        // and then Generate a new JWT token and send it to user
        try {
            final UserDetails userDetails = customUserDetailsService.loadUserByUsername(userAuthReqDto.getUsername());
            final String token = jwtUtils.generateToken(userDetails);
            return ResponseEntity.ok(new AuthenticationResponse(token));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Something went wrong in token generating part/n"+e.getMessage());
        }


    }


    @PostMapping("/signout")
    public String logoutUser() {
        return "Under Constraction";

        //TODO:complete singuot
    }

    @GetMapping("/me")
    public  String whoAmI(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
       }

    @GetMapping(value = "/myprofile")
    @ResponseBody
    public String myProfile(Principal principal) {
        return principal.getName();
    }

}
