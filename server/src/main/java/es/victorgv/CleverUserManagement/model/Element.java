package es.victorgv.CleverUserManagement.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/** Cada elemento representará una aplicación, servicio, microservicio suscaptible de ser
 * administrado mediante asignación permisos usuario
 */
@Entity
@Setter @Getter @NoArgsConstructor
@Table(uniqueConstraints =
        {@UniqueConstraint(name = "element_code_uk", columnNames = { "code" }),
         @UniqueConstraint(name = "element_name_uk", columnNames = { "name" })
        })
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "element_id_generator")
    @SequenceGenerator(name="element_id_generator", sequenceName = "element_seq")
    private Long elementId;

    @Column(length = 20, nullable = false)
    private String code;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 500, nullable = true)
    private String description;

}
