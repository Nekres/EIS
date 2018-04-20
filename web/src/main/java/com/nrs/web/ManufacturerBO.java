/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.web;

import com.nrs.vehicle.entity.Manufacturer;
import com.nrs.vehicle.entity.Vehicle;
import java.util.List;

/**
 *
 * @author root
 */
public interface ManufacturerBO {
    public List<Manufacturer> getAllManufacturers();
    public Manufacturer findById(Integer id);
    public void update(Manufacturer m);
}
