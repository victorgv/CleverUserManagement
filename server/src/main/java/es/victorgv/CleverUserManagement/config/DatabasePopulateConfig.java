package es.victorgv.CleverUserManagement.config;

import es.victorgv.CleverUserManagement.service.ServiceService;
import es.victorgv.CleverUserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DatabasePopulateConfig {
    private UserService userService;
    private ServiceService serviceService;

    @Autowired
    public DatabasePopulateConfig(UserService userService, ServiceService serviceService) {
        this.userService = userService;
        this.serviceService = serviceService;
    }

    @PostConstruct
    public void populate() {
        userService.doInitDatabasePopulate();
        serviceService.doInitDatabasePopulate();

    }



}
