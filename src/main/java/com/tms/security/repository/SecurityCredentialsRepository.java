package com.tms.security.repository;

import com.tms.security.domain.SecurityCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityCredentialsRepository extends JpaRepository<SecurityCredentials, Long> {
}
