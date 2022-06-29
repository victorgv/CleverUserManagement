package es.victorgv.CleverUserManagement.service;

import es.victorgv.CleverUserManagement.model.Element;
import es.victorgv.CleverUserManagement.model.User;
import es.victorgv.CleverUserManagement.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ElementService {
    private final ElementRepository elementRepository;

    public ElementService(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    public void doInitDatabasePopulate() {
        if (elementRepository.findAll().isEmpty()) {
            Element elementUsrManagementAPP = new Element();
            elementUsrManagementAPP.setCode("USR");
            elementUsrManagementAPP.setName("User Management APP");
            elementUsrManagementAPP.setDescription("this application, used in order to administrate users who can manage other users");

            elementRepository.save(elementUsrManagementAPP);
        }
    }
}
