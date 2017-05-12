/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.post.project.repository;

import com.mycompany.post.project.entity.IEntity;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Luana
 * @param <T>
 */


@Dependent
public abstract class GenericRepository<T extends IEntity> {
    
    @PersistenceContext(unitName = "com.mycompany_post-project_war_1.0-SNAPSHOTPU")
    private EntityManager entityManager;
    
    private final Class<T> targetClass;

    public GenericRepository(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    public void save(T t) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(t);
        this.entityManager.getTransaction().commit();
    }
    
    public void update(T t) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(t);
        this.entityManager.getTransaction().commit();
    }
    
    public T find(Long id) {
        return this.entityManager.find(targetClass, id);
    }
    
    public void remove(T t) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(this.find(t.getId()));
        this.entityManager.getTransaction().commit();
    }
    
    public List<T> list() {
        return this.entityManager.createQuery(getFindAllQuery()).getResultList();
    }
    
    protected abstract String getFindAllQuery();
    
}
