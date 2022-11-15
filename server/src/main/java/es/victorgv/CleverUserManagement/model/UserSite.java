package es.victorgv.CleverUserManagement.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "user_site")
@Setter @Getter @NoArgsConstructor
public class UserSite {
    @EmbeddedId
    public UserSiteId userSiteId;

    @Column(nullable = false)
    public boolean selected_default;

   /* @ManyToOne(fetch = FetchType.LAZY) // Muchos "UserSite" para un "User"
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    Site site;*/


    // Clase para poder incorporar los dos campos PK de user y site com PK de UserSite
    @Embeddable
    @Setter @Getter @NoArgsConstructor
    public static class UserSiteId implements Serializable {
        public UUID userUID;
        public UUID siteUID;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserSiteId userSiteId = (UserSiteId) o;
            return Objects.equals(userUID, userSiteId.userUID) && Objects.equals(siteUID, userSiteId.siteUID);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userUID,siteUID);
        }
    }

}
