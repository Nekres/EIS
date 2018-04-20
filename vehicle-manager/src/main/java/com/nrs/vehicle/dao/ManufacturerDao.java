/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.vehicle.dao;

import com.nrs.vehicle.entity.Manufacturer;
import com.nrs.vehicle.entity.Vehicle;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


/**
 *
 * @author root
 */
@Transactional
public class ManufacturerDao implements ManufacturerDaoInterface<Manufacturer, Integer>{
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void persist(Manufacturer entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Manufacturer entity) {
        entityManager.merge(entity);
    }

    @Override
    public Manufacturer findById(Integer id) {
        Manufacturer m = entityManager.find(Manufacturer.class, id);
        return m;
    }

    @Override
    public void delete(Manufacturer entity) {
        entityManager.remove(entity);
    }

    @Override
    public List<Manufacturer> getAll() {
        return entityManager.createQuery("SELECT m FROM Manufacturer m").getResultList();
    }
    
}
