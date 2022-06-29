package es.victorgv.CleverUserManagement.controller;

import es.victorgv.CleverUserManagement.DTO.UserLoginDTO;
import es.victorgv.CleverUserManagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-management/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO) { // Endpoint para validación usr/pass
        if (userService.validateUser(userLoginDTO)) {
            userLoginDTO.setPassword("blablabla");
            return new ResponseEntity<>(userLoginDTO, HttpStatus.OK);
        } else {
            userLoginDTO.setPassword("blablabla");
            return new ResponseEntity<>(userLoginDTO, HttpStatus.UNAUTHORIZED);
        }

    }


}
