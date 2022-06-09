package org.jaywikstrom.golftracker.repository;

import org.jaywikstrom.golftracker.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
}
