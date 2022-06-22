package org.jaywikstrom.golftracker;

import org.assertj.core.api.Assertions;
import org.jaywikstrom.golftracker.repository.CoursesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CourseRepositoryTest {

    @Autowired
    CoursesRepository coursesRepository;

    @Test
    public void findAllByOrderByCourseName(){
        coursesRepository.findAllByOrderByCourseName();
        Assertions.assertThat(coursesRepository.findAllByOrderByCourseName());
    }
}
