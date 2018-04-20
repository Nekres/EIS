/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.vehicle.dao;

import com.nrs.vehicle.entity.Vehicle;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author nrs
 */
@Transactional
public class VehicleDao implements VehicleDaoInterface<Vehicle, Integer>{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void persist(Vehicle entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Vehicle entity) {
        entityManager.merge(entity);
    }

    @Override
    public Vehicle findById(Integer id) {
        Vehicle v = entityManager.find(Vehicle.class, id);
        return v;
    }

    @Override
    public void delete(Vehicle entity) {
        entityManager.remove(entity);
    }

    @Override
    public List<Vehicle> getAll() {
        return entityManager.createQuery("SELECT v FROM Vehicle v").getResultList();
    }

    @Override
    public List<Vehicle> executeQuery(String query) {
        return entityManager.createQuery(query).getResultList();
    }

    
}
