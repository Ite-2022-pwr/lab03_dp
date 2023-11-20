package pl.pwr.ite.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.pwr.ite.server.model.enums.UserType;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`user`")
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class User extends EntityBase {

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private UserType type;

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @OneToMany(mappedBy = "user")
    private Set<Registration> registrations = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Decision> decisions = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Report> reports = new HashSet<>();
}
