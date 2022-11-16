package es.victorgv.CleverUserManagement.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** Cada Sevicio (Service) representará una aplicación con interface gráfica, servicio, microservicio susceptible de ser
 * administrado mediante asignación permisos usuario
 */
@Entity
@Setter @Getter @NoArgsConstructor
@Table(uniqueConstraints =
        {@UniqueConstraint(name = "service_code_uk", columnNames = { "code" }),
         @UniqueConstraint(name = "service_name_uk", columnNames = { "name" })
        })
public class Service {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID serviceUID;

    @Column(length = 20, nullable = false)
    private String code;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 500, nullable = true)
    private String description;

    @OneToMany
    @JoinColumn(name = "serviceUID")
    private List<Permission> permissions = new ArrayList<Permission>();

}
