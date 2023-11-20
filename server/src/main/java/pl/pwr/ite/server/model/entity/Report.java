package pl.pwr.ite.server.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Table
@Entity
@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class Report extends EntityBase {

    @OneToOne
    @JoinColumn(nullable = false)
    private Registration registration;

    @Column(insertable = false, updatable = false, nullable = false, name = "registration_id")
    private UUID registrationId;

    @ManyToOne
    @JoinColumn(nullable = false, name = "u_id")
    private User user;

    @Column(insertable = false, updatable = false, nullable = false, name = "u_id")
    private UUID userId;

    @Column(nullable = false, length = 1024)
    private String description;

    public void setRegistration(Registration registration) {
        this.registration = registration;
        this.registrationId = registration == null ? null : registration.getId();
    }

    public void setUser(User user) {
        this.user = user;
        this.userId = user == null ? null : user.getId();
    }
}
