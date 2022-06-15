package org.jaywikstrom.golftracker.repository;

import org.jaywikstrom.golftracker.model.Ratings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingsRepository extends JpaRepository<Ratings, Integer> {

    @Query(value = "SELECT r FROM Ratings r JOIN r.userRatings ur WHERE ur.email = :userEmail")
    List <Ratings> findAllByUserEmail(@Param("userEmail") String userEmail);

    @Query(value = "INSERT INTO userRatings(ratingsId, userId) VALUES (:ratingsId, :userId)", nativeQuery = true)
    public void saveUserRatings(@Param("ratingsId") Integer ratingId, @Param("userId") Long userId);

    @Query(value = "SELECT COUNT(r) FROM Ratings r JOIN r.userRatings ur WHERE ur.id = :userId")
    public Long countRatingsById(Long userId);

    public Long countById(Integer id);

}
