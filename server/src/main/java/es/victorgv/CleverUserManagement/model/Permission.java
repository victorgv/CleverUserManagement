package es.victorgv.CleverUserManagement.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Setter @Getter @NoArgsConstructor
public class Permission {
    @EmbeddedId
    private PermissionID permissionID;

    private UUID permissionUID_parent;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 400, nullable = true)
    private String comment;

    @Column(length = 100, nullable = false)
    private String componentLink;

    // Clase para poder incorporar los dos campos PK de user y site com PK de UserSite
    @Embeddable
    @Setter @Getter @NoArgsConstructor
    public static class PermissionID implements Serializable {
        @ManyToOne
        @JoinColumns({
                @JoinColumn(name = "siteUID"),
                @JoinColumn(name = "serviceUID")
        })
        public Service service;

        @Column
        public UUID permissionUID;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PermissionID that = (PermissionID) o;

            if (!Objects.equals(service, that.service)) return false;
            return Objects.equals(permissionUID, that.permissionUID);
        }

        @Override
        public int hashCode() {
            int result = service != null ? service.hashCode() : 0;
            result = 31 * result + (permissionUID != null ? permissionUID.hashCode() : 0);
            return result;
        }
    }

}
