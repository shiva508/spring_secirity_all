package com.security.repository.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.model.Registration;
@Repository
public interface RegistrationJpa extends JpaRepository<Registration, Integer>,RegistrationDao {

}
