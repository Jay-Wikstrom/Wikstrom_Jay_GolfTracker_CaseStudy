package org.jaywikstrom.golftracker.model;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

/*
    This class is used to build the Ratings Table
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Ratings {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private Integer courseRating;

    @ManyToMany()
    @JoinTable(
            name = "userRatings",
            joinColumns = @JoinColumn(name = "ratingsId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "id")
    )
    private Set<User> userRatings;
}
