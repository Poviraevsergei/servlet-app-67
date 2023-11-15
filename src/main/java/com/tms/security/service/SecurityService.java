package com.tms.security.service;

import com.tms.domain.Person;
import com.tms.domain.Role;
import com.tms.exception_resolver.SameUserInDatabaseException;
import com.tms.repository.PersonRepository;
import com.tms.security.domain.SecurityCredentials;
import com.tms.security.domain.dto.AuthRequest;
import com.tms.security.domain.dto.RegistrationDTO;
import com.tms.security.repository.SecurityCredentialsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SecurityService {

    private final SecurityCredentialsRepository securityCredentialsRepository;
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public Optional<String> generateToken(AuthRequest authRequest) {
        Optional<SecurityCredentials> personCredentials =
                securityCredentialsRepository.getByPersonLogin(authRequest.getLogin());
        if (personCredentials.isPresent() &&
                passwordEncoder.matches(authRequest.getPassword(), personCredentials.get().getPersonPassword())) {
            return Optional.of(jwtUtils.generateJwtToken(authRequest.getLogin()));
        }
        return Optional.empty();
    }

    @Transactional(rollbackOn = Exception.class)
    public void registration(RegistrationDTO registrationDTO) {
        Optional<SecurityCredentials> result = securityCredentialsRepository.getByPersonLogin(registrationDTO.getPersonLogin());
        if (result.isPresent()) {
            throw new SameUserInDatabaseException();
        }
        Person person = new Person();
        person.setFirstName(registrationDTO.getFirstName());
        person.setSecondName(registrationDTO.getSecondName());
        person.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        person.setAge(registrationDTO.getAge());
        Person userInfoResult = personRepository.save(person);

        SecurityCredentials securityCredentials = new SecurityCredentials();
        securityCredentials.setPersonLogin(registrationDTO.getPersonLogin());
        securityCredentials.setPersonPassword(passwordEncoder.encode(registrationDTO.getPersonPassword()));
        securityCredentials.setRole(Role.USER);
        securityCredentials.setPersonId(userInfoResult.getId());
        securityCredentialsRepository.save(securityCredentials);
    }

    public boolean checkAccessById(Long id) {
        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        String userRole = String.valueOf(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getAuthorities()
                .stream()
                .findFirst()
                .get());
        Long userId = securityCredentialsRepository.findUserIdByLogin(userLogin);

        return (userId.equals(id) || userRole.equals("ROLE_ADMIN"));
    }
}

