/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.vehicle.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author nrs
 */
@Entity
public abstract class MotorCar extends Vehicle{
    
    @Column(nullable = false)
    private boolean isPublic;
    @Column(name = "auto_bodywork_type", nullable = false)
    private boolean automotiveBodyworkType;
}
