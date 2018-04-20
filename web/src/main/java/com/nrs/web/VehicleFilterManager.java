/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.web;

import com.nrs.vehicle.entity.Manufacturer;
import com.nrs.vehicle.entity.Vehicle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
public class VehicleFilterManager implements Serializable {

    private VehicleBO vehicleBo;
    private List<String> filters = new ArrayList<>();
    private String selectedVehicleType = "";
    private Double selectedCost = 0.0;

    private ManufacturerBO manufacturerBO;
    private String selectedManufacturer;
    private HashMap<String, Manufacturer> manufacturers = new HashMap<>();
    private List<Vehicle> filteredVehicles;
    

    public Double getSelectedCost() {
        return selectedCost;
    }

    public void setSelectedCost(Double selectedCost) {
        this.selectedCost = selectedCost;
    }

    public VehicleFilterManager() {
        filters.add("Motorcar");
        filters.add("Motorcycle");
    }

    public List<Vehicle> getAll() {
        return vehicleBo.getAllVehicles();
    }

    public Vehicle findById(Integer id) {
        return vehicleBo.findById(id);
    }

    public void setVehicleBo(VehicleBO vehicleBo) {
        this.vehicleBo = vehicleBo;
    }

    public String getSelectedVehicleType() {
        return selectedVehicleType;
    }

    public void setSelectedVehicleType(String selectedVehicleType) {
        this.selectedVehicleType = selectedVehicleType;
    }

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    public String register() {
        String sql = "FROM " + selectedVehicleType + " WHERE cost > " + selectedCost + " AND manufacturer_id = " + manufacturers.get(selectedManufacturer).getId() ;
        this.filteredVehicles = vehicleBo.executeFilterQuery(sql);
        String message = "";
        message = message + selectedCost + ",";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You've Registered In:", message));
        return "";
    }

    public HashMap<String, Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(HashMap<String, Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public List<Vehicle> getFilteredVehicles() {
        return filteredVehicles;
    }

    public void setFilteredVehicles(List<Vehicle> filteredVehicles) {
        this.filteredVehicles = filteredVehicles;
    }
    
    public String getSelectedManufacturer() {
        return selectedManufacturer;
    }

    public void setSelectedManufacturer(String selectedManufacturer) {
        this.selectedManufacturer = selectedManufacturer;
    }

    public ManufacturerBO getManufacturerBO() {
        return manufacturerBO;
    }

    public void setManufacturerBO(ManufacturerBO manufacturerBO) {
        this.manufacturerBO = manufacturerBO;
    }

    public List<String> getAllManufacturers() {
        List<String> manufacturersList = new ArrayList<String>();
        this.manufacturerBO.getAllManufacturers().forEach((t) -> {
            manufacturers.put(t.getName(), t);
            manufacturersList.add(t.getName());
        });
        return manufacturersList;
    }
}
