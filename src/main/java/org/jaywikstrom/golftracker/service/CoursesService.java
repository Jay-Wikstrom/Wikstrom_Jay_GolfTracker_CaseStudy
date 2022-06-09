package org.jaywikstrom.golftracker.service;

import org.jaywikstrom.golftracker.model.Courses;
import org.jaywikstrom.golftracker.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;

    public List<Courses> listAll(){
        return (List<Courses>) coursesRepository.findAll();
    }
}