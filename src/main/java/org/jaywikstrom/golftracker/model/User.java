package org.jaywikstrom.golftracker.model;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/*
    This class is used to build the User Table
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(nullable = false)
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    @ManyToMany(mappedBy = "userRatings")
    private Set<Ratings> userRatings;

    @ManyToMany(mappedBy = "userScores")
    private Set<Scores> userScores;

}
