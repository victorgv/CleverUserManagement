package es.victorgv.CleverUserManagement.repository;

import es.victorgv.CleverUserManagement.model.Site;
import es.victorgv.CleverUserManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SiteRepository  extends JpaRepository<Site, UUID> {

}

