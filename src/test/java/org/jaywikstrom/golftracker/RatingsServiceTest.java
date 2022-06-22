package org.jaywikstrom.golftracker;

import org.assertj.core.api.Assertions;
import org.jaywikstrom.golftracker.model.User;
import org.jaywikstrom.golftracker.repository.RatingsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RatingsServiceTest {

    @Autowired
    private RatingsRepository ratingsRepository;

    @Test
    public void listAllByUserEmail(){
        User user = User.builder()
                .firstName("User")
                .lastName("Test")
                .email("usertest@email.com")
                .password("password123")
                .build();

        String userEmail = String.valueOf(ratingsRepository.findAllByUserEmail("usertest@email.com"));
        Assertions.assertThat(userEmail.length() > 0);
    }





}
