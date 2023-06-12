package lv.venta.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Driver;
import lv.venta.services.IDriverCRUDservice;

@Service
public class DriverCRUDservice implements IDriverCRUDservice{

	
	public List<Driver> drivers = new ArrayList<>();
	
	
	public void setDrivers(List<Driver> drivers) {
	        this.drivers = drivers;
	  }
	
	
	@Override
	public Driver selectDriverById(int driverId) {

		for(Driver driver: drivers) {
			if(driver.getDriver_id()==driverId) {
				return driver;
			}
		}
		return null;
	}

	@Override
	public void deleteDriverById(int driverId) {
		
		for(Driver driver: drivers) {
			if(driver.getDriver_id() == driverId) {
				drivers.remove(driver);
				break;
			}
		}
		
	}

	@Override
	public void insertNewDriver(Driver driver) {
	    for (Driver temp : drivers) {
	        if (temp.getName().equals(driver.getName()) && temp.getSurname().equals(driver.getSurname()) && temp.getCategory() == driver.getCategory()) {
	            return;
	        }
	    }
	    Driver newDriver = new Driver(driver.getName(), driver.getSurname(), driver.getCategory());
	    drivers.add(newDriver);
	}

		
		
		
		
	

	@Override
	public void updateDriverById(int driverId) {
		//TODO
		
	}

	@Override
	public List<Driver> showAllDrivers() {
		List<Driver> allDrivers = new ArrayList<>();
		
		for(Driver driver: drivers) {
			allDrivers.add(driver);
		}
		
		return allDrivers;
	}
	
	
	

}
