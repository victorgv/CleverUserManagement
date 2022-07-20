package es.victorgv.CleverUserManagement.repository;

import es.victorgv.CleverUserManagement.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository <Service, Long> {
}
