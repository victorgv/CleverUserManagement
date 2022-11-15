package es.victorgv.CleverUserManagement.repository;

import es.victorgv.CleverUserManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUserName(String userName);
}
