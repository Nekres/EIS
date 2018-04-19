/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.web;

import com.nrs.vehicle.dao.VehicleDaoInterface;
import com.nrs.vehicle.entity.Vehicle;
import java.util.List;

/**
 *
 * @author root
 */
public class VehicleBOImpl implements VehicleBO{
    
    VehicleDaoInterface<Vehicle, Integer> vehicleDao;
    
    @Override
    public List<Vehicle> getAllVehicles() {
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
    
}
