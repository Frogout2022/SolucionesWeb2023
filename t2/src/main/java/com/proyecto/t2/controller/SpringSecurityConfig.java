package com.proyecto.t2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
                .requestMatchers("/*", "/polleria/login*", "/cliente/registro*").permitAll()
                .requestMatchers("/extranet/**").hasAuthority("ROL_USUARIO")
                .requestMatchers("/intranet/**").hasAuthority("ROL_ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin(login -> login.loginPage("/polleria/login")
                        .defaultSuccessUrl("/validacion/login", false))
                .logout(logout -> logout
                        .permitAll());
                //.exceptionHandling(handling -> handling.accessDeniedPage("/acceso-denegado"));

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
        return (web)->web.ignoring().requestMatchers("/assets/img/**","/css/**","/js/**", "/assets/**");
    }
    
}
