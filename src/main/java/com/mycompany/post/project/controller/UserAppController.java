/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.post.project.controller;

import com.mycompany.post.project.entity.UserApp;
import com.mycompany.post.project.service.UserAppService;
import com.mycompany.post.project.service.exception.ServiceException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Luana
 */
@Named
@SessionScoped
public class UserAppController implements Serializable {
    
    private UserApp userApp;

    @Inject
    private UserAppService service;
    
    public UserAppController() {
        this.userApp = new UserApp();
    }

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }
    
    public String login() {
        try {
            this.service.save(this.userApp);
        } catch (ServiceException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(ex.getMessage()));
            return null;
        }
        return "post";
    }
    
}
