package es.victorgv.CleverUserManagement.config;

import es.victorgv.CleverUserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DatabasePopulateConfig {
    private UserService userService;

    @Autowired
    public DatabasePopulateConfig(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void populate() {
        userService.doInitDatabasePopulate();

    }



}
