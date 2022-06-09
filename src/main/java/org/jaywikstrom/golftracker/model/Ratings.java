package org.jaywikstrom.golftracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
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


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "userRatings",
            joinColumns = @JoinColumn(name = "ratingsId", referencedColumnName = "courseRatingId"),
            inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "id")
    )
    private Set<User> userRatings;
}
