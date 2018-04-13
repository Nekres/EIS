/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.vehicle.entity;

import com.nrs.vehicle.dao.VehicleDao;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author nrs
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"classpath:vehicle-dao-context.xml"});
        VehicleDao dao = (VehicleDao)ctx.getBean("vehicleDao");
        Vehicle v = new Motorcycle();
        v.setCost(200);
        v.setHeight(500);
        v.setLength(20000);
        v.setMaxSpeed(1200);
        v.setWeight(400);
        Manufacturer m = new Manufacturer();
        m.setCountry("China");
        m.setName("IDK");
        m.setSiteUrl("http://not-exist.com");
        v.setManufacturer(m);
        
        Engine e = new Engine();
        e.setTransmissionType("MECHANICAL");
        v.setEngine(e);
        dao.beginTransaction();
        Store s = new Store();
        s.setAddress("some address");
        s.setName("some name");
        HashSet<StoreVehicleInterim> set = new HashSet<>();
        StoreVehicleInterim svi = new StoreVehicleInterim();
        svi.setStore(s);
        svi.setVehicle(v);
        set.add(svi);
        v.setStores(set);
        dao.persist(v);
    }
}
