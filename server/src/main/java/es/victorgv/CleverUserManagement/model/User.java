package es.victorgv.CleverUserManagement.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Setter @Getter @NoArgsConstructor
@Table(name = "user_")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID userUID;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 400, nullable = true)
    private String comment;

    @Column(length = 100, nullable = false)
    private String userName;


    @Column(length = 100, nullable = false)
    private String userNameType; // StaffNumber, email, SITA adress, DNI, userCode

    @Column(length = 100, nullable = false)
    private String validationMethodType; // password, LDAP, token

    @Column(length = 250, nullable = false)
    private String password;

    @ManyToMany
    @JoinTable( name = "user_site",
            joinColumns = @JoinColumn(referencedColumnName = "userUID", name = "userUID"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "siteUID", name = "siteUID"))
    public List<Site> sites;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userUID != null ? !userUID.equals(user.userUID) : user.userUID != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = userUID != null ? userUID.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
