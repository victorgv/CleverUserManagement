package es.victorgv.CleverUserManagement.repository;

import es.victorgv.CleverUserManagement.model.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepository extends JpaRepository <Element, Long> {
}
