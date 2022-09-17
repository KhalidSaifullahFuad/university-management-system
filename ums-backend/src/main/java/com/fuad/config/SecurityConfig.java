package com.fuad.config;

import com.fuad.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    private final AuthService authService;

    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/api/student/**","/api/course/**","/api/department/**").hasRole("STUDENT")
                .anyRequest().authenticated()
                .and()
                .authorizeRequests()
                .antMatchers("/api/**").hasRole("TEACHER")
                .and()
                .build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(authService).passwordEncoder(passwordEncoder);
    }

}
