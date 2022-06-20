package org.jaywikstrom.golftracker.repository;


import org.jaywikstrom.golftracker.model.Courses;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
    List<Courses> findAllByOrderByCourseName();
}
