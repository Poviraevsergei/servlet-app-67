package com.tms.security.repository;

import com.tms.security.domain.SecurityCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecurityCredentialsRepository extends JpaRepository<SecurityCredentials, Long> {
    Optional<SecurityCredentials> getByPersonLogin(String login);

    @Query(
            nativeQuery = true,
            value = "SELECT person_id FROM security_credentials WHERE person_login = ?1")
    Long findUserIdByLogin(String login);
}
