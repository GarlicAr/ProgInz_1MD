package lv.venta.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Driver;
import lv.venta.models.Trip;
import lv.venta.repos.IDriverRepo;
import lv.venta.repos.ITripRepo;
import lv.venta.services.IDriverCRUDservice;

@Service
public class DriverCRUDservice implements IDriverCRUDservice{
	
	@Autowired
	private IDriverRepo driverRepo;
	
	@Autowired
	private ITripRepo tripRepo;
	
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
				for(Trip trip : tripRepo.findAll()) {
					if(trip.getDriver().getDriver_id() == driverId) {
						trip.setDriver(null);
						tripRepo.save(trip);
					}
					
				}
				
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
	    
	    showAllDrivers().add(driver);
	    driverRepo.save(driver);
	    

	}

		
		
		
		
	

	@Override
	public void updateDriverById(int driverId, Driver inputDriver) {
	    for (Driver driver : showAllDrivers()) {
	        if (driver.getDriver_id() == driverId) {
	        	
	     	    if (driver != null) {
	     	        driver.setName(inputDriver.getName());
	     	        driver.setSurname(inputDriver.getSurname());
	     	        driver.setCategory(inputDriver.getCategory());
	     	        
	     	        
	     	        showAllDrivers().add(driver);
	     	        driverRepo.save(driver);
	     	    }
	        }
	    }
	}


	@Override
	public List<Driver> showAllDrivers() {
		return (List<Driver>)driverRepo.findAll();
	}
	
	
	

}
