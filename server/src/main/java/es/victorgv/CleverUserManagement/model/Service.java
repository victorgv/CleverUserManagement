package es.victorgv.CleverUserManagement.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "service_id_generator")
    @SequenceGenerator(name="service_id_generator", sequenceName = "service_seq")
    private Long serviceId;

    @Column(length = 20, nullable = false)
    private String code;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 500, nullable = true)
    private String description;

}
