package org.websparrow.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class UserService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;//numeric ID because they are better and usernames usually change.
    @NaturalId(mutable=true)
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName; // Save the name of the user

    @Column(name = "password", nullable = false)
    private String password; // Save the password of the user (should be encrypted/hashed using authenticationprovided bcript)

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
