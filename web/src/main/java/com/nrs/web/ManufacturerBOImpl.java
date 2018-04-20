/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.web;

import com.nrs.vehicle.dao.ManufacturerDaoInterface;
import com.nrs.vehicle.dao.VehicleDaoInterface;
import com.nrs.vehicle.entity.Manufacturer;
import com.nrs.vehicle.entity.Vehicle;
import java.util.List;

/**
 *
 * @author root
 */
public class ManufacturerBOImpl implements ManufacturerBO{
    private ManufacturerDaoInterface<Manufacturer, Integer> manufacturerDao;
    
    @Override
    public List<Manufacturer> getAllManufacturers() {
        return this.manufacturerDao.getAll();
    }

    @Override
    public Manufacturer findById(Integer id) {
        return this.manufacturerDao.findById(id);
    }

    @Override
    public void update(Manufacturer m) {
        this.manufacturerDao.update(m);
    }

    public ManufacturerDaoInterface<Manufacturer, Integer> getManufacturerDao() {
        return manufacturerDao;
    }

    public void setManufacturerDao(ManufacturerDaoInterface<Manufacturer, Integer> manufacturerDao) {
        this.manufacturerDao = manufacturerDao;
    }
    
}
