package es.victorgv.CleverUserManagement.service;

import es.victorgv.CleverUserManagement.model.UserSite;
import es.victorgv.CleverUserManagement.repository.UserSiteRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserSiteService {
    private final UserSiteRepository userSiteRepository;

    public UserSiteService(UserSiteRepository userSiteRepository) {
        this.userSiteRepository = userSiteRepository;
    }

    public void doInitDatabasePopulate(UUID userUID, UUID siteUID) {
        if (userSiteRepository.findAll().isEmpty()) {
            UserSite userSite = new UserSite();
            UserSite.UserSiteId userSiteId = new UserSite.UserSiteId();
            userSiteId.setUserUID(userUID);
            userSiteId.setSiteUID(siteUID);
            userSite.setUserSiteId(userSiteId);
            userSite.setSelected_default(true);
            userSiteRepository.save(userSite);
        }
    }
}
