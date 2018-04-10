/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.vehicle.dao;

import com.nrs.vehicle.entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author nrs
 */
public class VehicleDao implements VehicleDaoInterface<Vehicle, Integer>{
    private SessionFactory sessionFactory;
    private Session currentSession;
    private Transaction currentTransaction;
    @Override
    public void persist(Vehicle entity) {
        currentSession.save(entity);
    }

    @Override
    public void update(Vehicle entity) {
        currentSession.update(entity);
    }

    @Override
    public Vehicle findById(Integer id) {
        Vehicle v = currentSession.get(Vehicle.class, id);
        return v;
    }

    @Override
    public void delete(Vehicle entity) {
        currentSession.delete(entity);
    }

    @Override
    public Session openSession() {
        this.currentSession = sessionFactory.openSession();
        return this.currentSession;
    }

    @Override
    public Session openSessionWithTransaction() {
        this.currentSession = sessionFactory.openSession();
        this.currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    @Override
    public void closeSession() {
        this.currentSession.close();
    }

    @Override
    public void closeSessionWithTransaction() {
        this.currentTransaction.commit();
        this.currentSession.close();
    }

    @Override
    public Session getCurrentSession() {
        return this.currentSession;
    }

    @Override
    public Transaction getCurrentTransaction() {
        return this.currentTransaction;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
}
