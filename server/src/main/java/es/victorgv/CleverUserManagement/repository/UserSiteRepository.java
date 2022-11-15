package es.victorgv.CleverUserManagement.repository;

import es.victorgv.CleverUserManagement.model.User;
import es.victorgv.CleverUserManagement.model.UserSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserSiteRepository extends JpaRepository<UserSite, UserSite.UserSiteId> {
}
