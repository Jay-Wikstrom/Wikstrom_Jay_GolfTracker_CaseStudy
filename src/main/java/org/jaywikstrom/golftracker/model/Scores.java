package org.jaywikstrom.golftracker.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/*
    This class is used to build the Scores Table
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Scores {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private Integer courseScore;

    @Column(nullable = false)
    private Integer userScore;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ManyToMany()
    @JoinTable(
            name = "userScores",
            joinColumns = @JoinColumn(name = "scoresId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "id")
    )
    private Set<User> userScores;
}
