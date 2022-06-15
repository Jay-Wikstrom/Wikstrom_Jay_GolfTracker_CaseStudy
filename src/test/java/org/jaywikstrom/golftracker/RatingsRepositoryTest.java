package org.jaywikstrom.golftracker;

import org.assertj.core.api.Assertions;
import org.jaywikstrom.golftracker.model.Ratings;
import org.jaywikstrom.golftracker.repository.RatingsRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RatingsRepositoryTest {

    @Autowired
    private RatingsRepository ratingsRepository;

//    @Test
//    @Order(1)
//    @Rollback(value = false)
//    public void saveRatingTest(){
//        Ratings ratings = Ratings.builder()
//                .courseName("ABC")
//                .courseRating(7)
//                .build();
//
//
//        ratingsRepository.save(ratings);
//
//        Assertions.assertThat(ratings.getId()).isGreaterThan(0);
//    }


}
