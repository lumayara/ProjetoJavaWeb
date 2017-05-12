/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.post.project.service;

import com.mycompany.post.project.entity.IEntity;
import com.mycompany.post.project.service.exception.ServiceException;
import java.util.List;

/**
 *
 * @author Luana
 * @param <T>
 */
public interface IService<T extends IEntity> {
    
    public void save(T t) throws ServiceException;
    public void update(T t) throws ServiceException;
    public T find(Long id) throws ServiceException;
    public void remove(T t) throws ServiceException;
    public List<T> list() throws ServiceException;
    
}
