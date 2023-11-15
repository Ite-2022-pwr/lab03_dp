package pl.pwr.ite.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.pwr.ite.model.enums.RegistrationStatus;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class Registration extends EntityBase {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RegistrationStatus status;

    @ManyToOne
    @JoinColumn(name = "u_id")
    private User user;

    @Column(insertable = false, updatable = false, name = "u_id")
    private UUID userId;

    @Column(nullable = false)
    private LocalDateTime time;

    @OneToOne(mappedBy = "registration")
    private Report report;

    @OneToOne(mappedBy = "registration")
    private Decision decision;

    @OneToMany(mappedBy = "registration")
    private Set<Tree> trees = new HashSet<>();

    public void setUser(User user) {
        this.user = user;
        this.userId = user == null ? null : user.getId();
    }
}
