package org.jaywikstrom.golftracker.repository;

import org.jaywikstrom.golftracker.model.Ratings;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingsRepository extends JpaRepository<Ratings, Integer> {
}
