package org.jaywikstrom.golftracker.repository;

import org.jaywikstrom.golftracker.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/*
    This class provides data access to the DB
 */
@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
    // List courses in ascending order
    List<Courses> findAllByOrderByCourseName();
}
