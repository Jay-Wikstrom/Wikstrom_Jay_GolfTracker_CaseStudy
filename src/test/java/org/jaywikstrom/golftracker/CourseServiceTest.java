package org.jaywikstrom.golftracker;

import org.assertj.core.api.Assertions;
import org.jaywikstrom.golftracker.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CourseServiceTest {
    @Autowired
    CoursesService coursesService;

    public void listAll(){
        coursesService.listAll();
        Assertions.assertThat(coursesService.listAll());
    }
}
