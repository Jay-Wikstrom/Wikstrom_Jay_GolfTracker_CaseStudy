package org.jaywikstrom.golftracker.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

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
    private Integer courseRatingId;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private Integer courseRating;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "userRatings",
            joinColumns = @JoinColumn(name = "ratingsId", referencedColumnName = "courseRatingId"),
            inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "id")
    )
    private Set<User> userRatings;
}
