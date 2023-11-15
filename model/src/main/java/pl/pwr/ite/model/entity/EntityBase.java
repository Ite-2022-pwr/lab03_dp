package pl.pwr.ite.model.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class EntityBase {

    @Id
//    @GeneratedValue(generator = "uuid_generator")
//    @GenericGenerator(name = "uuid_generator", type = org.hibernate.id.uuid.UuidGenerator.class)
    @UuidGenerator
    @ToString.Include
    @EqualsAndHashCode.Include
    private UUID id;
}
