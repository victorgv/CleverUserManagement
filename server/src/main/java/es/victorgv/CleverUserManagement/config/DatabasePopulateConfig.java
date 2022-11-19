package es.victorgv.CleverUserManagement.config;



import es.victorgv.CleverUserManagement.model.Site;
import es.victorgv.CleverUserManagement.service.ServiceService;
import es.victorgv.CleverUserManagement.service.SiteService;
import es.victorgv.CleverUserManagement.service.UserService;
import es.victorgv.CleverUserManagement.service.UserSiteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Configuration
public class DatabasePopulateConfig {
    private SiteService siteService;
    private UserService userService;
    private ServiceService serviceService;
    private UserSiteService userSiteService;

    private Logger logger = LoggerFactory.getLogger(getClass());



    public DatabasePopulateConfig(SiteService siteService, UserService userService, ServiceService serviceService, UserSiteService userSiteService) {
        this.userService = userService;
        this.serviceService = serviceService;
        this.siteService = siteService;
        this.userSiteService = userSiteService;
    }

    @PostConstruct
    public void populate() {
        logger.error("*********************Error prueba prueba prueba");
        logger.trace("*********************Prueba de traza");
        UUID userUid = userService.doInitDatabasePopulate();
        Site site= siteService.doInitDatabasePopulate();
        serviceService.doInitDatabasePopulate(site);

        if (userUid != null && site != null) {
            userSiteService.doInitDatabasePopulate(userUid, site.getSiteUID());
        }


    }



}
