package com.proyecto.t2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.proyecto.t2.model.service.UserService;

@Configuration
public class SpringSecurityConfig {
    @Autowired
    private UserService userService;
    
    @Bean
    public static BCryptPasswordEncoder encriptarPassword(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void criptografiaPassword(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(encriptarPassword());
        //auth.userDetailsService(userService);

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
                .requestMatchers("/*", "/polleria/login2*").permitAll()
                .anyRequest().authenticated()
                .and().formLogin(login -> login.loginPage("/polleria/login2").defaultSuccessUrl("/validacion/login2", true)).logout(logout -> logout.permitAll());

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
        return (web)->web.ignoring().requestMatchers("/assets/img/**","/css/**","/js/**");
    }
    /* 
    @Bean
    public InMemoryUserDetailsManager configureAuthentication(){
        List<UserDetails> listaUsuarios = new ArrayList<>();
        List<GrantedAuthority> rolesAdministradores = new ArrayList<>();
        List<GrantedAuthority> rolesUsuarios = new ArrayList<>();

        rolesAdministradores.add(new SimpleGrantedAuthority("ADMIN"));
        rolesUsuarios.add(new SimpleGrantedAuthority("USER"));

        listaUsuarios.add(new User("Administrador", "{noop}123456", rolesAdministradores));
        listaUsuarios.add(new User("Jorge", "{noop}123456", rolesUsuarios));
        

        return new InMemoryUserDetailsManager(listaUsuarios);
    }
    */
}
