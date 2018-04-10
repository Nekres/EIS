/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.vehicle.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author nrs
 */
@Entity
public class Motorcycle extends Vehicle{
    
    @Column(nullable = false)
    private boolean isOneManType;
    @Column(nullable = false)
    private boolean hasSidecar;

    public boolean isIsOneManType() {
        return isOneManType;
    }

    public void setIsOneManType(boolean isOneManType) {
        this.isOneManType = isOneManType;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }
    
    
}
