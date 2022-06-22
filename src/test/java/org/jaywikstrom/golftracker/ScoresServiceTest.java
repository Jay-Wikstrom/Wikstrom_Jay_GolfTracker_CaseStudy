package org.jaywikstrom.golftracker;

import org.assertj.core.api.Assertions;
import org.jaywikstrom.golftracker.model.User;
import org.jaywikstrom.golftracker.repository.ScoresRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ScoresServiceTest {

    @Autowired
    ScoresRepository scoresRepository;



    @Test
    public void listAllByUserEmail() {
        User user = User.builder()
                .firstName("User")
                .lastName("Test")
                .email("usertest@email.com")
                .password("password123")
                .build();

        String userEmail = String.valueOf(scoresRepository.findAllByUserEmail("usertest@email.com"));
        Assertions.assertThat(userEmail.length() > 0);
    }
}
