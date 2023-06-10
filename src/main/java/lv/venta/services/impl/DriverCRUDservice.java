package lv.venta.services.impl;

import java.util.ArrayList;
import java.util.List;

import lv.venta.models.Driver;
import lv.venta.services.IDriverCRUDservice;

public class DriverCRUDservice implements IDriverCRUDservice{

	
	List<Driver> drivers = new ArrayList<>();
	
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
			}
		}
		
	}

	@Override
	public void insertNewDriver(Driver driver) {
		
		drivers.add(driver);
		
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
