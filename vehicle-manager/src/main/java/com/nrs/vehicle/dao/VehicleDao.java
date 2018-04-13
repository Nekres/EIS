/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.vehicle.dao;

import com.nrs.vehicle.entity.Vehicle;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author nrs
 */
public class VehicleDao implements VehicleDaoInterface<Vehicle, Integer>{
    private EntityManager entityManager;
    private Transaction currentTransaction;
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
    public void beginTransaction() {
        entityManager.getTransaction().begin();
    }

    @Override
    public void commit() {
        entityManager.getTransaction().commit();
    }

    
}
