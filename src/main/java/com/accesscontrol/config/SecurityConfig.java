package com.accesscontrol.config;

import com.accesscontrol.entities.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService inMemoryUserDetailsManager() {
        UserDetails user = org.springframework.security.core.userdetails.User.withUsername("defaultUser")
                .password(passwordEncoder().encode("password"))
                .roles(Role.USER.name())
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/index.html").authenticated()
                                .requestMatchers("/api/**").authenticated()
                                .anyRequest().permitAll())
                .formLogin(form -> form.permitAll())
                .logout(logout -> logout.permitAll());
        return http.build();
    }
}
