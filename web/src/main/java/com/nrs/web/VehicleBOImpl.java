/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.web;

import com.nrs.vehicle.dao.VehicleDaoInterface;
import com.nrs.vehicle.entity.Vehicle;
import java.util.List;
import org.jboss.logging.Logger;

/**
 *
 * @author root
 */
public class VehicleBOImpl implements VehicleBO{
    private VehicleDaoInterface<Vehicle, Integer> vehicleDao;
    @Override
    public List<Vehicle> getAllVehicles() {
        Logger.getLogger("vehicle").info("INVOKED");
        return vehicleDao.getAll();
    }
    @Override
    public Vehicle findById(Integer id) {
        return vehicleDao.findById(id);
    }
    @Override
    public void update(Vehicle v) {
        vehicleDao.update(v);
    }

    public VehicleDaoInterface<Vehicle, Integer> getVehicleDao() {
        return vehicleDao;
    }

    public void setVehicleDao(VehicleDaoInterface<Vehicle, Integer> vehicleDao) {
        this.vehicleDao = vehicleDao;
    }
    
    public List<Vehicle> executeFilterQuery(final String sql){
        return vehicleDao.executeQuery(sql);
    }
    
    
    
}
