package es.victorgv.CleverUserManagement.service;

import es.victorgv.CleverUserManagement.DTO.UserLoginDTO;
import es.victorgv.CleverUserManagement.model.User;
import es.victorgv.CleverUserManagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID doInitDatabasePopulate() {
        if (userRepository.findAll().isEmpty()) {
            User userAdmin = new User();
            userAdmin.setName("Superuser");
            userAdmin.setUserName("SUPER");
            userAdmin.setPassword("super");
            userAdmin.setUserNameType("STAFFNUMBER");
            userAdmin.setValidationMethodType("PASSWORD");

            return userRepository.save(userAdmin).getUserUID();
        } else {
            return null;
        }

    }

    public boolean validateUser(UserLoginDTO userLoginDTO) {
        User user = userRepository.findByUserName(userLoginDTO.getUserName());

        return (user !=null) && (userLoginDTO.getPassword().equals(user.getPassword()));

    }




}
