package es.victorgv.CleverUserManagement.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/** Cada Sevicio (Service) representará una aplicación con interface gráfica, servicio, microservicio susceptible de ser
 * administrado mediante asignación permisos usuario
 */
@Entity
@Setter @Getter @NoArgsConstructor
@Table(name = "Service", indexes = {
        @Index(name = "idx_service_siteuid_unq", columnList = "siteUID, serviceUID", unique = true)
}, uniqueConstraints = {
        @UniqueConstraint(name = "service_code_uk", columnNames = {"siteUID","code"})
})
public class Service {

    @EmbeddedId
    private ServiceID serviceID;

    @Column(length = 25, nullable = false)
    private String code;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 500, nullable = true)
    private String description;

    @OneToMany
    @JoinColumns({
            @JoinColumn(name = "siteUID"),
            @JoinColumn(name = "serviceUID")
    })
    private List<Permission> permissions = new ArrayList<Permission>();

    // Clase para poder incorporar los dos campos PK de user y site com PK de Service
    @Embeddable
    @Setter @Getter @NoArgsConstructor
    public static class ServiceID implements Serializable {
        @ManyToOne
        @JoinColumn(name = "siteUID")
        public Site site;

        @Column
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(
                name = "UUID",
                strategy = "org.hibernate.id.UUIDGenerator"
        )
        public UUID serviceUID;
    }
}
