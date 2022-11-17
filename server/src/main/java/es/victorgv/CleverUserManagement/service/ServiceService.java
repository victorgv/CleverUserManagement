package es.victorgv.CleverUserManagement.service;

import es.victorgv.CleverUserManagement.model.Service;
import es.victorgv.CleverUserManagement.model.Site;
import es.victorgv.CleverUserManagement.repository.ServiceRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@org.springframework.stereotype.Service
@Transactional
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public void doInitDatabasePopulate(Site site) {
        if (site != null && serviceRepository.findAll().isEmpty()) {
            Service serviceUsrManagementAPP = new Service();
            Service.ServiceID serviceID = new Service.ServiceID();
            serviceID.setSite(site);
            serviceUsrManagementAPP.setCode("USR");
            serviceUsrManagementAPP.setName("User Management APP");
            serviceUsrManagementAPP.setDescription("this application, used in order to administrate users who can manage other users");
            serviceRepository.save(serviceUsrManagementAPP);
        }
    }
}
