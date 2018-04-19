/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.web;

import com.nrs.vehicle.entity.Vehicle;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class VehicleBean {
    
    private VehicleBO vehicleBo;
    
    
    public String sayHello(){
        Logger.getLogger(VehicleBO.class.getName()).info("SUMMONED");
        return "Hello";
    } 
    
    public Vehicle findById(Integer id){
        Logger.getLogger("asd").info("BOOOO"  + (vehicleBo == null));
        return vehicleBo.findById(id);
    }
    
    public void setVehicleBo(VehicleBO vehicleBo) {
        this.vehicleBo = vehicleBo;
    }
    
    
}
