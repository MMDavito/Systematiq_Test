package org.websparrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.websparrow.service.*;

/**
 * The interface User repository.
 *
 * @author David
 */
public interface UserRepository extends JpaRepository<UserService,Long> {
    UserService findByUserName(String userName);

}