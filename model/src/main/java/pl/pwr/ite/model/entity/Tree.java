package pl.pwr.ite.model.entity;

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
public class Tree extends EntityBase {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Registration registration;

    @Column(insertable = false, updatable = false, nullable = false, name = "registration_id")
    private UUID registrationId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Double diameter;

    public void setRegistration(Registration registration) {
        this.registration = registration;
        this.registrationId = registration == null ? null : registration.getId();
    }
}
