package com.tms.security.service;

import com.tms.exception_resolver.UserFromDatabaseNotFound;
import com.tms.security.domain.SecurityCredentials;
import com.tms.security.repository.SecurityCredentialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final SecurityCredentialsRepository credentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SecurityCredentials> userFromDatabase = credentialsRepository.getByPersonLogin(username);
        if (userFromDatabase.isEmpty()) {
            throw new UserFromDatabaseNotFound();
        }
        SecurityCredentials user = userFromDatabase.get();
        return User
                .withUsername(user.getPersonLogin())
                .password(user.getPersonPassword())
                .roles(user.getRole().toString())
                .build();
    }
}
