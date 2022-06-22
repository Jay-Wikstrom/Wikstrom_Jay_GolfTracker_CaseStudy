package org.jaywikstrom.golftracker.model;

import lombok.*;
import javax.persistence.*;

/*
    This class is used to build the Courses Table
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Courses {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String courseName;

    private String courseLocation;
}
