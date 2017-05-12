/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.post.project.service;

import com.mycompany.post.project.entity.UserApp;
import com.mycompany.post.project.repository.UserAppRepository;
import com.mycompany.post.project.service.exception.ServiceException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Luana
 */
@RequestScoped
public class UserAppService implements IService<UserApp>, Serializable {
    
    @Inject
    private UserAppRepository repository;

    @Override
    public void save(UserApp t) throws ServiceException {
        if (t.getName() == null || t.getName().trim().isEmpty()) {
            throw new ServiceException("Nome inválido!");
        }
        this.repository.save(t);
    }

    @Override
    public void update(UserApp t) throws ServiceException {
        if (t.getName() == null || t.getName().trim().isEmpty()) {
            throw new ServiceException("Nome inválido!");
        }
        this.repository.update(t);
    }

    @Override
    public UserApp find(Long id) throws ServiceException {
        return this.repository.find(id);
    }

    @Override
    public void remove(UserApp t) throws ServiceException {
        this.repository.remove(t);
    }

    @Override
    public List<UserApp> list() throws ServiceException {
        return this.repository.list();
    }
    
}
