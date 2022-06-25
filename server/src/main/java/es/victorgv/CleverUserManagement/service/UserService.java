package es.victorgv.CleverUserManagement.service;

import es.victorgv.CleverUserManagement.model.User;
import es.victorgv.CleverUserManagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void doInitDatabasePopulate() {
        if (userRepository.findAll().isEmpty()) {
            User userAdmin = new User();
            userAdmin.setName("Superuser");
            userAdmin.setUserName("SUPER");
            userAdmin.setPassword("super");

            userRepository.save(userAdmin);
        }
    }




}
