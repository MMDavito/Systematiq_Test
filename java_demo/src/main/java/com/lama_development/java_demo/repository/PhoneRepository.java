package com.lama_development.java_demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.lama_development.java_demo.service.*;

/**
 * The interface Phone repository.
 *
 * @author Robley Gori - ro6ley.github.io
 */
public interface PhoneRepository extends JpaRepository<Phone, Long> {
  
}