package com.tms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)   //отключаем csrf
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers(new AntPathRequestMatcher("/person", "GET")).hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()) //это для самастоятельной настройки Basic
                .build();
    }

    //IN_MEMORY
    @Bean
    public UserDetailsService users() {
        UserDetails userAdmin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        UserDetails userUser = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(userUser, userAdmin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
