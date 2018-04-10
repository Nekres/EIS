/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.vehicle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nrs
 */
@Entity
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "engine_type")
    private EngineType engineType;
    @Enumerated(EnumType.STRING)
    @Column(name = "cooling_system")
    private CoolingSystem coolingSystem;
    @Enumerated(EnumType.STRING)
    @Column
    private TransmissionType transmission;
    
    enum CoolingSystem{
        WATER,AIR;
    }
    enum TransmissionType{
        MECHANICAL, ELECTRICAL,HYDRO_VOLUME, COMBINED;
    }
    enum EngineType{
        GASOLINE, DIESEL, GAS,ROTARY_PISTON;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public CoolingSystem getCoolingSystem() {
        return coolingSystem;
    }

    public void setCoolingSystem(CoolingSystem coolingSystem) {
        this.coolingSystem = coolingSystem;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }
    
    
    
}
