/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.vehicle.dao;

import java.util.List;

/**
 *
 * @author root
 */
public interface ManufacturerDaoInterface<E,K> {
    public void persist(E entity);
    public void update(E entity);
    public E findById(K id);
    public void delete(E entity);
    public List<E> getAll();
}
