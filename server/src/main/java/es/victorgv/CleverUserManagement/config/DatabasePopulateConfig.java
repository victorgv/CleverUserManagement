package es.victorgv.CleverUserManagement.config;

import es.victorgv.CleverUserManagement.service.ServiceService;
import es.victorgv.CleverUserManagement.service.SiteService;
import es.victorgv.CleverUserManagement.service.UserService;
import es.victorgv.CleverUserManagement.service.UserSiteService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Configuration
public class DatabasePopulateConfig {
    private SiteService siteService;
    private UserService userService;
    private ServiceService serviceService;
    private UserSiteService userSiteService;



    public DatabasePopulateConfig(SiteService siteService, UserService userService, ServiceService serviceService, UserSiteService userSiteService) {
        this.userService = userService;
        this.serviceService = serviceService;
        this.siteService = siteService;
        this.userSiteService = userSiteService;
    }

    @PostConstruct
    public void populate() {
        UUID userUid = userService.doInitDatabasePopulate();
        UUID siteUID = siteService.doInitDatabasePopulate();
        serviceService.doInitDatabasePopulate();

        if (userUid != null && siteUID != null) {
            userSiteService.doInitDatabasePopulate(userUid, siteUID);
        }


    }



}
