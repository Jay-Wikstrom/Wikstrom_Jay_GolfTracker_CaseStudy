package org.jaywikstrom.golftracker.repository;


import org.jaywikstrom.golftracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
    This class provides data access to the DB
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Find user by email
    User findByEmail(String email);
}
