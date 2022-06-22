package org.jaywikstrom.golftracker;

import org.assertj.core.api.Assertions;
import org.jaywikstrom.golftracker.model.User;
import org.jaywikstrom.golftracker.repository.ScoresRepository;
import org.jaywikstrom.golftracker.repository.UserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ScoresRepositoryTest {
    @Autowired
    ScoresRepository scoresRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTest(){
        User user = User.builder()
                .firstName("User")
                .lastName("Test")
                .email("usertest@email.com")
                .password("password123")
                .build();

        userRepository.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void findAllByUserEmailTest(){
        Assertions.assertThat(scoresRepository.findAllByUserEmail("usertest@email.com")).isNotNull();
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void deleteUserTest(){
        User user = userRepository.findByEmail("usertest@email.com");
        userRepository.delete(user);

        Assertions.assertThat(user == null);
    }
}
