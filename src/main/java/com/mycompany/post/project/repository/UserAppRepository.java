/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.post.project.repository;

import com.mycompany.post.project.entity.UserApp;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Luana
 */
@RequestScoped
public class UserAppRepository extends GenericRepository<UserApp> implements Serializable {

    public UserAppRepository() {
        super(UserApp.class);
    }

    @Override
    protected String getFindAllQuery() {
        return "SELECT u FROM UserApp u";
    }
    
}
