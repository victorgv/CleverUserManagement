package es.victorgv.CleverUserManagement.config;

import es.victorgv.CleverUserManagement.service.ServiceService;
import es.victorgv.CleverUserManagement.service.SiteService;
import es.victorgv.CleverUserManagement.service.UserService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DatabasePopulateConfig {
    private SiteService siteService;
    private UserService userService;
    private ServiceService serviceService;


    public DatabasePopulateConfig(SiteService siteService, UserService userService, ServiceService serviceService) {
        this.userService = userService;
        this.serviceService = serviceService;
        this.siteService = siteService;
    }

    @PostConstruct
    public void populate() {
        userService.doInitDatabasePopulate();
        serviceService.doInitDatabasePopulate();
        siteService.doInitDatabasePopulate();

    }



}
