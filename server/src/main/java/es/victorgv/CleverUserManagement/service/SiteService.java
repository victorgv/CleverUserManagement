package es.victorgv.CleverUserManagement.service;

import es.victorgv.CleverUserManagement.model.Site;
import es.victorgv.CleverUserManagement.repository.SiteRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SiteService {
    private final SiteRepository siteRepository;

    public SiteService(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public Site doInitDatabasePopulate() {
        if (siteRepository.findAll().isEmpty()) {
            // Creamos un SITE por defecto para administrar el sistema
            Site siteManagementAPP = new Site();
            siteManagementAPP.setSiteCode("MANAGEMENT");
            siteManagementAPP.setName("MANAGEMENT SITE");
            siteManagementAPP.setDescription("SITE para administración del sistema");

            return siteRepository.save(siteManagementAPP);
        } else {
            return null;
        }

    }




}
