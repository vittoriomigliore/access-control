package com.accesscontrol.usermanagement.repositories;

import com.accesscontrol.usermanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username LIKE %:filter%")
    List<User> findByFilter(@Param("filter") String filter);
}
