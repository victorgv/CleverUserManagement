package es.victorgv.CleverUserManagement.config;

import es.victorgv.CleverUserManagement.service.ElementService;
import es.victorgv.CleverUserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DatabasePopulateConfig {
    private UserService userService;
    private ElementService elementService;

    @Autowired
    public DatabasePopulateConfig(UserService userService, ElementService elementService) {
        this.userService = userService;
        this.elementService = elementService;
    }

    @PostConstruct
    public void populate() {
        userService.doInitDatabasePopulate();
        elementService.doInitDatabasePopulate();

    }



}
