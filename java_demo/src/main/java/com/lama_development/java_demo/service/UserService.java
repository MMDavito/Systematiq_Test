package com.lama_development.java_demo.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

public class UserService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; // Each phone will be given an auto-generated unique identifier when stored

    @Column(name = "user_name", nullable = false)
    private String userName; // Save the name of the phone

    @Column(name = "password", nullable = false)
    private String password; // Save the operating system running in the phone
}
