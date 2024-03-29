package com.userapplication.user.application.repository;

import com.userapplication.user.application.bean.User;
import com.userapplication.user.application.controller.BackendService;
import com.userapplication.user.application.service.AccountService;
import com.userapplication.user.application.service.DepartmentService;
import com.userapplication.user.application.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Component
@Transactional
public class AuditTrailListener {

    @Autowired
    private static BackendService backendController;
    private static Log log = LogFactory.getLog(AuditTrailListener.class);

//observer pattern
//    JPA specifies seven optional lifecycle events that are called:
//
//    before persist is called for a new entity – @PrePersist
//    after persist is called for a new entity – @PostPersist
//    before an entity is removed – @PreRemove
//    after an entity has been deleted – @PostRemove
//    before the update operation – @PreUpdate
//    after an entity is updated – @PostUpdate
//    after an entity has been loaded – @PostLoad

    @Autowired
    public void init(BackendService backendController) {
        AuditTrailListener.backendController = backendController;
        log.info("Initializing with dependency [" + backendController + "]");
    }

    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(User user) {
        if (user.getId() == 0) {
            log.info("[USER AUDIT] About to add a user");
        } else {
            log.info("[USER AUDIT] About to update/delete user: " + user.getId());
        }
    }

    @PostPersist
    @PostUpdate
    private void afterAnyUpdate(User user) {
        log.info("[USER AUDIT] add/update complete for user: " + user.getId());
        new Thread(() -> {
            backendController.saveDepartment(user.getId());
        }).start();
        new Thread(() -> {
            backendController.saveAccount(user.getId());
        }).start();
    }

    @PostRemove
    private void afterRemoving(User user) throws InterruptedException {
        log.info("[USER AUDIT] delete complete for user: " + user.getId());
        new Thread(() -> {
            backendController.deleteDepartment(user.getId());
        }).start();
        new Thread(() -> {
            backendController.deleteAccount(user.getId());
        }).start();
    }

    @PostLoad
    private void afterLoad(User user) {
        log.info("[USER AUDIT] user loaded from database: " + user.getId());
    }


}
