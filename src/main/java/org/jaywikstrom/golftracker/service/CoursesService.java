package org.jaywikstrom.golftracker.service;

import org.jaywikstrom.golftracker.model.Courses;
import org.jaywikstrom.golftracker.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;

    /*
        List all courses in ascending order
     */

    public List<Courses> listAll(){
        return (List<Courses>) coursesRepository.findAllByOrderByCourseName();
    }

    /*
        Save new Course Data
     */
    public void save(Courses courses){
        coursesRepository.save(courses);
    }
}
