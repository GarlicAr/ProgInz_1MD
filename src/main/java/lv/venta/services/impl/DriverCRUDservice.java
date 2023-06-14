package lv.venta.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Driver;
import lv.venta.repos.IDriverRepo;
import lv.venta.services.IDriverCRUDservice;

@Service
public class DriverCRUDservice implements IDriverCRUDservice{
	
	private IDriverRepo driverRepo;
	
	 	@Autowired
	    public DriverCRUDservice(IDriverRepo driverRepo) {
	        this.driverRepo = driverRepo;
	    }

	

	
	@Override
	public Driver selectDriverById(int driverId) {

		for(Driver driver: showAllDrivers()) {
			if(driver.getDriver_id()==driverId) {
				return driver;
			}
		}
		return null;
	}

	@Override
	public void deleteDriverById(int driverId) {
		
		for(Driver driver: showAllDrivers()) {
			if(driver.getDriver_id() == driverId) {
				
				driverRepo.delete(driver);
				
				break;
			}
		}
		
	}

	@Override
	public void insertNewDriver(Driver driver) {
	    for (Driver temp : showAllDrivers()) {
	        if (temp.getName().equals(driver.getName()) && temp.getSurname().equals(driver.getSurname()) && temp.getCategory() == driver.getCategory()) {
	            return;
	        }
	    }
	    
	    driverRepo.save(driver);
	    
	    showAllDrivers().add(driver);
	   
	    

	}

		
		
		
		
	

	@Override
	public void updateDriverById(int driverId) {
	    for (Driver driver : showAllDrivers()) {
	        if (driver.getDriver_id() == driverId) {
	        	
	            break;
	        }
	    }
	}


	@Override
	public List<Driver> showAllDrivers() {
		return (List<Driver>)driverRepo.findAll();
	}
	
	
	

}
