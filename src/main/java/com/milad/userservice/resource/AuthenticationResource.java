package com.milad.userservice.resource;

import com.milad.userservice.dto.UserAuthenticationRequestDto;
import com.milad.userservice.dto.UserAuthenticationResponseDto;
import com.milad.userservice.model.User;
import com.milad.userservice.security.JwtTokenUtil;
import com.milad.userservice.service.UserService;
import com.milad.userservice.service.impl.CustomUserDetailsService;
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
@RequestMapping("/api")
@Slf4j
public class AuthenticationResource {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;


    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.status(200).body(user);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserAuthenticationRequestDto userAuthReqDto) throws Exception {
        // First step checks user credential
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAuthReqDto.getUsername(), userAuthReqDto.getPassword()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Incorrect Username and Password");
        }

        // If User exists in context then
        // add user in security context???? by UserDetailsService loadUserByUsername() ???
        // and then Generate a new JWT token and send it to user
        try {
            final UserDetails userDetails = customUserDetailsService.loadUserByUsername(userAuthReqDto.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);
            return ResponseEntity.ok(new UserAuthenticationResponseDto(token));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong in token generating part/n"+e.getMessage());
        }


    }

    @GetMapping("/users/info")
    public  String getLoginedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
       }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

}
