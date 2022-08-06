package com.milad.userservice.security;

import com.milad.userservice.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity

public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtAuthorizationFilter JwtAuthorizationFilter;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resurces/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers("/api/login","/api/register").permitAll()// login is default define in spring security context
                .antMatchers("/api/user/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/api/hellowuser/**").hasAuthority("ROLE_USER")
                .anyRequest().authenticated();//full access to all of user



        http.addFilterBefore(JwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);


        //payman config
        /*
        http.authorizeRequests()
                .antMatchers("/user/**").access("hasRole('USER')")
                .antMatchers("/admin/**").hasRole("Role_ADMIN") //equal by access("hasRole('ADMIN')")
                .and().logout().logoutUrl("/logout")
                .and().formLogin().loginPage("/login")
                .and() ;

         */
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
