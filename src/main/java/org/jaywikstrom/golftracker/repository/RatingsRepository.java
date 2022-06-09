package org.jaywikstrom.golftracker.repository;

import org.jaywikstrom.golftracker.model.Ratings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingsRepository extends JpaRepository<Ratings, Integer> {

    @Query(value = "SELECT r FROM Ratings r JOIN r.userRatings ur WHERE ur.email = :userEmail")
    List <Ratings> findAllByUserId(@Param("userEmail") String userEmail);
}
