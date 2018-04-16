/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.test.it;

import com.nrs.vehicle.dao.VehicleDao;
import com.nrs.vehicle.entity.Engine;
import com.nrs.vehicle.entity.Manufacturer;
import com.nrs.vehicle.entity.Motorcycle;
import com.nrs.vehicle.entity.Store;
import com.nrs.vehicle.entity.StoreVehicleInterim;
import com.nrs.vehicle.entity.Vehicle;
import com.nrs.vehicle.entity.MotorCar;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author root
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-vehicle-dao-context.xml"})
public class VehicleDaoTest {
    @Autowired
    VehicleDao dao;
    
    Process database;
    Engine engine;
    Store store;
    Manufacturer manufacturer;
    Vehicle vehicle;
    Motorcycle motorcycle;
    MotorCar motorcar;
    
    @Before
    public void setUp() throws IOException{
        File db = new File("src/test/resources/h2-1.4.197.jar");
        database = Runtime.getRuntime().exec(new String[]{"java","-jar",db.getAbsolutePath()});
        
        Vehicle v = new Motorcycle();
        v.setCost(200);
        v.setHeight(500);
        v.setLength(20000);
        v.setMaxSpeed(1200);
        v.setWeight(400);
        
        manufacturer = new Manufacturer();
        manufacturer.setCountry("China");
        manufacturer.setName("IDK");
        manufacturer.setSiteUrl("http://not-exist.com");
        v.setManufacturer(manufacturer);
        
        engine = new Engine();
        engine.setTransmissionType("MECHANICAL");
        v.setEngine(engine);
        
        store = new Store();
        store.setAddress("some address");
        store.setName("some name");
        HashSet<StoreVehicleInterim> set = new HashSet<>();
        StoreVehicleInterim svi = new StoreVehicleInterim();
        svi.setStore(store);
        svi.setVehicle(v);
        set.add(svi);
        v.setStores(set);
        
        dao.beginTransaction();
        dao.persist(v);
        dao.commit();
    }
    
    @Test
    public void testInsert(){
        dao.beginTransaction();
        Assert.assertNotEquals(dao.findById(1),null);
        Assert.assertNotEquals(dao.findById(1).getManufacturer().equals(manufacturer), true);
        Assert.assertNotEquals(dao.findById(1).getEngine().equals(engine), true);
        dao.commit();
    }
    @After
    public void destroy(){
        database.destroy();
    }
}
